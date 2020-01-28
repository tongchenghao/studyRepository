package simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:人类产品原型
 * @auth tongchenghao
 * @date 2020/1/26
 */
public class Person implements Cloneable{
    private int age;

    private String name;

    //爱好
    private ArrayList<String> hobby;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getHobby() {
        return hobby;
    }

    public void setHobby(ArrayList<String> hobby) {
        this.hobby = hobby;
    }

    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    public Person myClone() throws CloneNotSupportedException {
        Person copyPerson = (Person) super.clone();
        copyPerson.setHobby((ArrayList<String>) this.hobby.clone());
        return copyPerson;
    }
}

class CloneTest{
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(18);
        person.setName("tongchenghao");
        List<String> hobby = new ArrayList<>();
        hobby.add("run");
        hobby.add("read");
        person.setHobby((ArrayList<String>) hobby);

        try {
            /**
             * object对象的clone方法为浅拷贝
             * 只支持java的八大基本类型以及String类型的拷贝
             * 其他类型只是拷贝引用，而不是拷贝数据
             */
            Person copyPerson = person.clone();
            //拷贝得到一个新的对象所以false
            System.out.println(copyPerson == person);
            //拷贝对象数据来自拷贝原型
            System.out.println(copyPerson.getAge());
            System.out.println(copyPerson.getName());
            //list不被clone方法支持，浅拷贝只拷贝了其引用，所以原型对象的hobby和拷贝对象的hobby其实是一个list
            System.out.println(copyPerson.getHobby()==person.getHobby());
            System.out.println(person.getHobby().toString());
            System.out.println(copyPerson.getHobby().toString());
            //只修改了拷贝对象的爱好，却连原型的爱好也一起改变了，证明两者的爱好引用的是一个list
            List<String> copyPersonHobby = copyPerson.getHobby();
            copyPersonHobby.add("swimming");
            System.out.println(person.getHobby().toString());
            System.out.println(copyPerson.getHobby().toString());

            /**
             * 自己写的myclone方法对hobby也做了处理，解决了list只是引用的问题，但仍没有解决浅拷贝的问题
             */
            Person copyPerson2 = person.myClone();
            //拷贝得到一个新的对象所以false
            System.out.println(copyPerson2 == person);
            //拷贝对象数据来自拷贝原型
            System.out.println(copyPerson2.getAge());
            System.out.println(copyPerson2.getName());
            //myClone方法使hobby成为真正的拷贝
            System.out.println(copyPerson2.getHobby()==person.getHobby());
            System.out.println(person.getHobby().toString());
            System.out.println(copyPerson2.getHobby().toString());
            //只修改了拷贝对象的爱好，原型的爱好不会改变了，证明两者的爱好引用的不是一个list
            List<String> copyPerson2Hobby = copyPerson2.getHobby();
            copyPerson2Hobby.add("swimming");
            System.out.println(person.getHobby().toString());
            System.out.println(copyPerson2.getHobby().toString());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
