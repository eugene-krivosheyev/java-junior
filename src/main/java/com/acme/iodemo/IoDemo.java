package com.acme.iodemo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import java.io.*;

public class IoDemo {
    public static void main(String[] args) {
        //Blocking IO vs NIO2: Path
        File path = new File("test.txt");
        path = new File("df/54" + File.separator + "a.txt");
        path = new File("a", "b");
        path = new File("target", "test.ser");


        //IO Streams
        try (ObjectOutputStream out =
                new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(path)))) {

            out.writeObject(new Employee("qqqq", 2));
            out.writeObject(new Employee("wwww", 3));
            out.writeObject(new String("eeeee"));

        } catch (IOException e) {
            e.printStackTrace();
        }


        try (ObjectInputStream in =
                     new ObjectInputStream(
                        new BufferedInputStream(
                            new FileInputStream(path))
        )) {

            Employee employee1 = (Employee) in.readObject();
            System.out.println(employee1);
            Employee employee2 = (Employee) in.readObject();
            System.out.println(employee2);
            System.out.println((String)in.readObject());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

//Plain Old Java Object : POJO
//OXM: Object-XML-Mapping, OJM: Object-JSON-Mapping (Binding) (Jackson, Gson)

//Corba (IIOP) -> RMI (java-specific).
//Apache Thrift, google Protobuf
@RootElement
class Employee implements Serializable {
    private static long SerialVersionUID = 1L;

    private String name;
    @XmlTransient
    transient private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @XmlAttribute
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{" + this.getClass().getCanonicalName() + "}";
    }
}