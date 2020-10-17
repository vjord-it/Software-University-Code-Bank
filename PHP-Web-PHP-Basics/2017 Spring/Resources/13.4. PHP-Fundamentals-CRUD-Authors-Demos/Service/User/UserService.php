<?php


namespace Service\User;


use Adapter\DatabaseInterface;
use Data\Cities\City;
use Data\Countries\Country;
use Data\Genders\Gender;
use Data\Orientations\Orientation;
use Data\Users\AllUsersViewData;
use Data\Users\User;
use Data\Users\UserRegisterViewData;
use Data\Users\UserViewData;
use Exceptions\RegisterException;
use Service\Encryption\EncryptionServiceInterface;
use Service\Message\MessageService;

class UserService implements UserServiceInterface
{
    const MIN_AGE_ALLOWED = 18;

    private $allowedSortableColumns = [
        'birthday' => 'people.born_on',
        'country' => 'countries.name',
        'city' => 'cities.name'
    ];

    /**
     * @var DatabaseInterface
     */
    private $db;

    /**
     * @var EncryptionServiceInterface
     */
    private $encryptionService;

    public function __construct(DatabaseInterface $db,
                                EncryptionServiceInterface $encryptionService)
    {
        $this->db = $db;
        $this->encryptionService = $encryptionService;
    }

    public function getRegisterViewData(): UserRegisterViewData
    {
        $userRegisterViewData = new UserRegisterViewData();

        $stmt = $this->db->prepare("SELECT id, name FROM genders ORDER BY name");
        $stmt->execute();
        $userRegisterViewData->setGenders(
            function () use ($stmt) {
                while ($gender = $stmt->fetchObject(Gender::class)) {
                    yield $gender;
                }

            }
        );


        $stmt = $this->db->prepare("SELECT id, name FROM cities ORDER BY name");
        $stmt->execute();
        $userRegisterViewData->setCities(
            function () use ($stmt) {
                while ($city = $stmt->fetchObject(City::class)) {
                    yield $city;
                }

            }
        );

        $stmt = $this->db->prepare("SELECT id, name FROM countries ORDER BY name");
        $stmt->execute();
        $userRegisterViewData->setCountries(
            function () use ($stmt) {
                while ($country = $stmt->fetchObject(Country::class)) {
                    yield $country;
                }

            }
        );

        $stmt = $this->db->prepare("SELECT id, name FROM sexual_orientations ORDER BY id");
        $stmt->execute();
        $userRegisterViewData->setOrientations(
            function () use ($stmt) {
                while ($orientation = $stmt->fetchObject(Orientation::class)) {
                    yield $orientation;
                }

            }
        );

        return $userRegisterViewData;
    }

    public function register(string $firstName,
                             string $lastName,
                             string $nickname,
                             string $email,
                             string $password,
                             string $confirmPassword,
                             string $phone,
                             \DateTime $birthday,
                             int $genderId,
                             int $sexualOrientation,
                             int $countryId,
                             int $cityId,
                             string $description = null,
                             string $pictureUrl = null)
    {
        if ($password != $confirmPassword) {
            throw new RegisterException("Password mismatch");
        }

        $passwordHash = $this->encryptionService->encrypt($password);

        $interval = $birthday->diff(new \DateTime('now'));
        if ($interval->y < self::MIN_AGE_ALLOWED) {
            throw new RegisterException("Underage not allowed");
        }

        $query = "INSERT INTO people (
                       first_name,
                       last_name,
                       nickname,
                       email,
                       phone,
                       password,
                       gender_id,
                       born_on,
                       sexual_orientation_id,
                       country_id,
                       city_id,
                       description,
                       picture
                    ) VALUES (
                       ?,
                       ?,
                       ?,
                       ?,
                       ?,
                       ?,
                       ?,
                       ?,
                       ?,
                       ?,
                       ?,
                       ?,
                       ?
                    );";

        $stmt = $this->db->prepare($query);
        $stmt->execute(
            [
                $firstName,
                $lastName,
                $nickname,
                $email,
                $phone,
                $passwordHash,
                $genderId,
                $birthday->format('Y-m-d'),
                $sexualOrientation,
                $countryId,
                $cityId,
                $description,
                $pictureUrl
            ]
        );
    }

    public function login($username, $password): bool
    {
        $query = "SELECT
                   id,
                   password
                FROM
                   people
                WHERE
                   nickname = ?";
        $stmt = $this->db->prepare($query);
        $stmt->execute(
            [
                $username
            ]
        );
        /** @var User $user */
        $user = $stmt->fetchObject(User::class);
        if (!$user) {
            return false;
        }

        $passwordHash = $user->getPassword();

        if ($this->encryptionService->isValid($passwordHash, $password)) {
            $_SESSION['user_id'] = $user->getId();
            return true;
        }

        return false;
    }

    /**
     * @param null $sort
     * @param $isAsc
     * @return AllUsersViewData
     */
    public function findAll($sort = null, $isAsc = true): AllUsersViewData
    {
        return $this->find($sort, $isAsc);
    }

    public function findByFilter($gender,
                                 $orientation,
                                 $country,
                                 $city,
                                 $minAge,
                                 $maxAge,
                                 $sort = null,
                                 $isAsc = true): AllUsersViewData
    {

        $params = [];
        $where = " WHERE (YEAR(NOW()) - YEAR(people.born_on)) BETWEEN ? AND ?";
        $params[] = $minAge;
        $params[] = $maxAge;

        if ($gender > 0) {
            $where .= " AND people.gender_id = ?";
            $params[] = $gender;
        }

        if ($country > 0) {
            $where .= " AND people.country_id = ?";
            $params[] = $country;
        }

        if($orientation > 0) {
            $where .= " AND people.sexual_orientation_id = ?";
            $params[] = $orientation;
        }

        if ($city > 0) {
            $where .= " AND people.city_id = ?";
            $params[] = $city;
        }

        return $this->find($sort, $isAsc, $where, $params);
    }

    public function findOne($id): User
    {
        $query =  "SELECT
                   people.id,
                   people.first_name AS firstName,
                   people.last_name AS lastName,
                   people.nickname,
                   people.phone,
                   people.email,
                   people.born_on AS bornOn,
                   genders.name AS gender,
                   sexual_orientations.name AS orientation,
                   countries.name AS country,
                   cities.name AS city,
                   picture,
                   description
                FROM
                   people
                INNER JOIN
                   genders
                ON
                   people.gender_id = genders.id
                INNER JOIN
                   sexual_orientations
                ON
                   people.sexual_orientation_id = sexual_orientations.id
                INNER JOIN
                   countries
                ON
                   people.country_id = countries.id
                INNER JOIN
                   cities
                ON
                   people.city_id = cities.id
                WHERE
                   people.id = ?";

        $stmt = $this->db->prepare($query);
        $stmt->execute([$id]);

        /** @var User $user */
        $user = $stmt->fetchObject(User::class);
        if (!$user->getPicture()) {
            $user->setPicture(dirname($_SERVER['PHP_SELF']) . '/avatars/no-avatar.png');
        }

        $messageService = new MessageService($this->db);
        $user->setUnreadMessages($messageService->getNewMessages($id));

        return $user;
    }

    private function find($sort = null, $isAsc = true, $where = null, $params = [])
    {
        $query = "
                SELECT
                   people.id,
                   people.first_name AS firstName,
                   people.last_name AS lastName,
                   people.nickname,
                   people.phone,
                   people.email,
                   people.born_on AS bornOn,
                   genders.name AS gender,
                   sexual_orientations.name AS orientation,
                   countries.name AS country,
                   cities.name AS city,
                   picture
                FROM
                   people
                INNER JOIN
                   genders
                ON
                   people.gender_id = genders.id
                INNER JOIN
                   sexual_orientations
                ON
                   people.sexual_orientation_id = sexual_orientations.id
                INNER JOIN
                   countries
                ON
                   people.country_id = countries.id
                INNER JOIN
                   cities
                ON
                   people.city_id = cities.id";
        if ($where) {
            $query .= $where;
        }
        if ($sort) {
            if (array_key_exists($sort, $this->allowedSortableColumns)) {
                $query .= " ORDER BY " . $this->allowedSortableColumns[$sort];
            } else {
                $query .= ' ORDER BY people.id';
            }
            if ($isAsc) {
                $query .= " ASC";
            } else {
                $query .= " DESC";
            }
        }

        $stmt = $this->db->prepare($query);
        $stmt->execute($params);

        $yearsStmt = $this->db->prepare("SELECT (YEAR(NOW()) - YEAR(born_on)) AS years
FROM people
ORDER BY born_on ASC
LIMIT 1");
        $yearsStmt->execute();
        $years = $yearsStmt->fetchRow()['years'];

        $allUsers = new AllUsersViewData();
        $allUsers->setMinYears(self::MIN_AGE_ALLOWED);
        $allUsers->setMaxYears($years);
        $allUsers->setAdditionalData($this->getRegisterViewData());

        $lazyLoadedAllUsers = function() use($stmt)
        {
            /** @var UserViewData $user */
            while ($user = $stmt->fetchObject(UserViewData::class)) {
                if (!$user->getPicture()) {
                    $user->setPicture(dirname($_SERVER['PHP_SELF']) . '/avatars/no-avatar.png');
                }
                yield $user;
            }
        };
        $allUsers->setUsers($lazyLoadedAllUsers);

        return $allUsers;
    }

}