//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

public class Skeleton implements Monster
{
    private String name;
    private int size;

    public Skeleton(String x, int y){
        name = x;
        size = y;
    }
    public Skeleton(){
        name = "null" ;
        size = 0;
    }
    @Override
    public int getHowBig() {
        return size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isBigger(Monster other) {
        return size > other.getHowBig();
    }

    @Override
    public boolean isSmaller(Monster other) {
        return size < other.getHowBig();
    }

    @Override
    public boolean namesTheSame(Monster other) {
        return name.equals(other.getName());
    }
    public String toString(){
        String value = "Monster - ";
        return value + name + " "+ size;
    }
}