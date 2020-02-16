package racing.model;

public class Car {

    private static final int MAX_NAME_SIZE = 5;
    private final String name;
    private Position position;

    public Car(String name) {
        name = name.trim();
        checkNameLengthUnderSix(name);
        checkNullOrEmptyName(name);
        this.name = name;
        position = new Position();
    }

    public Car(String name, int position) {
        name = name.trim();
        checkNameLengthUnderSix(name);
        checkNullOrEmptyName(name);
        this.name = name;
        this.position = new Position(position);
    }


    private void checkNullOrEmptyName(String name) {
        if (name == null || name.isEmpty()){
            throw new NullPointerException("차이름은 공백 또는 빈 문자열일 수 없습니다.");
        }
    }

    private void checkNameLengthUnderSix(String name) {
        if (name.length() > MAX_NAME_SIZE){
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public boolean isNameEqual(String targetName) {
        return this.name.equals(targetName);
    }

    public void move(RandomNo randomNo){
        if (randomNo.isMovable()){
            position.add();
        }
    }

    public Position getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }

    public Car comparePositionSize(Car targetCar) {
        if (position.isBiggerThan(targetCar.getPosition())){
            return this;
        }
        return targetCar;
    }

    @Override
    public String toString(){
        return name;
    }
}
