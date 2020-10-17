<?php


namespace Data\Users;


use Data\Message\UnreadMessagesViewData;

class User
{
    private $id;

    private $firstName;

    private $lastName;

    private $nickname;

    private $password;

    private $phone;

    private $email;

    private $bornOn;

    private $gender;

    private $orientation;

    private $country;

    private $city;

    private $picture;

    private $description;

    /**
     * @var UnreadMessagesViewData
     */
    private $unreadMessages;

    /**
     * @return mixed
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @return mixed
     */
    public function getFirstName()
    {
        return $this->firstName;
    }

    /**
     * @return mixed
     */
    public function getLastName()
    {
        return $this->lastName;
    }

    /**
     * @return mixed
     */
    public function getNickname()
    {
        return $this->nickname;
    }

    /**
     * @return mixed
     */
    public function getPhone()
    {
        return $this->phone;
    }

    /**
     * @return mixed
     */
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * @return mixed
     */
    public function getBornOn()
    {
        return $this->bornOn;
    }

    /**
     * @return mixed
     */
    public function getGender()
    {
        return $this->gender;
    }

    /**
     * @return mixed
     */
    public function getOrientation()
    {
        return $this->orientation;
    }

    /**
     * @return mixed
     */
    public function getCountry()
    {
        return $this->country;
    }

    /**
     * @return mixed
     */
    public function getCity()
    {
        return $this->city;
    }

    /**
     * @return mixed
     */
    public function getPicture()
    {
        return $this->picture;
    }

    /**
     * @return mixed
     */
    public function getDescription()
    {
        return $this->description;
    }

    /**
     * @param mixed $picture
     */
    public function setPicture($picture)
    {
        $this->picture = $picture;
    }

    /**
     * @return mixed
     */
    public function getPassword()
    {
        return $this->password;
    }

    /**
     * @return UnreadMessagesViewData
     */
    public function getUnreadMessages(): UnreadMessagesViewData
    {
        return $this->unreadMessages;
    }

    /**
     * @param UnreadMessagesViewData $unreadMessages
     */
    public function setUnreadMessages(UnreadMessagesViewData $unreadMessages)
    {
        $this->unreadMessages = $unreadMessages;
    }





}