
/**
  * CS211 Winter2020 Assignment: TP1(Chapter: 10,Project: 3)
  * @Author(s): Team 3
  * @Date: 24/JAN/2020
  * @Task: Write a family DataBase program.
  * @See: TP1Client
  */
import java.util.ArrayList;

public class Person{
    private String name;
    private String mother;
    private String father;
    private ArrayList<String> children = new ArrayList<>();
    
    public Person(String name,String mother,String Father){
        this.name = name;
        this.mother = mother;
        this.father = father;
    }
    public Person(String name){
        this.name = name;
    }
    // add mother
    public void addMother(String m){
        this.mother = m;
    }
    // add Father
    public void addFather(String d){
        this.father = d;
    }
    // add Children with single string
    public void addChildren(String k){
        this.children.add(k);
    }
    // return name
    public String getName(){
        return name;
    }
    // return mother
    public String getMother(){
        return mother;
    }
    // return Father
    public String getFather(){
        return father;
    }
    // return Children
    public ArrayList<String> getChildren(){
        return(children);
    }
}

