package Lesson03IteratorsAndComparators.Exercises.pr08_pet_clinics;

import java.util.Iterator;

public class Clinic<P extends Pet> implements Iterable<Pet> {

    private static final String INVALID_OPERATION = "Invalid Operation!";

    private String name;
    private Pet[] rooms;

    public Clinic(String name, int rooms) throws InvalidOperationOnClinicException {
        if (rooms % 2 == 0 || rooms < 0) {
            throw new InvalidOperationOnClinicException(INVALID_OPERATION);
        }

        this.name = name;
        this.rooms = new Pet[rooms];
    }

    public boolean add(Pet pet) throws InvalidOperationOnClinicException {
        if (pet == null) {
            throw new InvalidOperationOnClinicException(INVALID_OPERATION);
        }
        Iterator<Integer> iterator = new RoomIteratorAdd();
        while (iterator.hasNext()) {
            int index = iterator.next();
            if (this.rooms[index] == null) {
                this.rooms[index] = pet;
                return true;
            }
        }
        return false;
    }

    public boolean release() {
        Iterator<Integer> iterator = new RoomIteratorRelease();
        while (iterator.hasNext()) {
            int index = iterator.next();
            if (this.rooms[index] != null) {
                this.rooms[index] = null;
                return true;
            }
        }
        return false;
    }

    public boolean hasEmptyRooms() {
        for (Pet pet : this.rooms) {
            if (pet == null) {
                return true;
            }
        }
        return false;
    }

    public String getRoom(int room) {
        if (this.rooms[room] == null) {
            return "Room empty";
        }

        return this.rooms[room].toString();
    }

    public String getAllRooms() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.rooms.length; i++) {
            sb.append(this.getRoom(i)).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public Iterator<Pet> iterator() {
        return new RoomsIterator();
    }

    private final class RoomsIterator implements Iterator<Pet> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < rooms.length;
        }

        @Override
        public Pet next() {
            return rooms[index++];
        }
    }

    private final class RoomIteratorAdd implements Iterator<Integer> {

        private int index = 0;
        private int[] indexes;

        public RoomIteratorAdd() {
            this.indexes = new int[rooms.length];
            int mid = rooms.length / 2;
            this.indexes[0] = mid;
            int ind = 1;
            for (int i = 1; i <= mid; i++) {
                this.indexes[ind++] = mid - i;
                this.indexes[ind++] = mid + i;
            }
        }

        @Override
        public boolean hasNext() {
            return index < this.indexes.length;
        }

        @Override
        public Integer next() {
            return this.indexes[index++];
        }
    }

    private final class RoomIteratorRelease implements Iterator<Integer> {

        private int index = 0;
        private int[] indexes;

        public RoomIteratorRelease() {
            this.indexes = new int[rooms.length];
            int ind = 0;
            for (int i = rooms.length / 2; i < rooms.length; i++) {
                this.indexes[ind++] = i;
            }
            for (int i = 0; i < rooms.length / 2; i++) {
                this.indexes[ind++] = i;
            }
        }

        @Override
        public boolean hasNext() {
            return index < this.indexes.length;
        }

        @Override
        public Integer next() {
            return this.indexes[index++];
        }
    }
}
