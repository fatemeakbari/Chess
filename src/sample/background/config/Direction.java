package sample.background.config;

public enum Direction {
    TOP(1),
    DOWN(-1);

    private int dir;

    Direction(int pointer){
        this.dir = pointer;
    }

    public int getDir() {
        return dir;
    }

    public boolean isDown(){
        if(this.equals(DOWN)){
            return true;
        }
        return false;
    }

    public boolean isTop(){
        if(this.equals(TOP)){
            return true;
        }
        return false;
    }
}
