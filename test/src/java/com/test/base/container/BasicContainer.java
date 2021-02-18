package com.test.base.container;

import java.util.Collection;
import java.util.HashSet;

public class BasicContainer {
    public static void main(String[] args) {
        Collection c = new HashSet();
        c.add("hello");
        c.add(new Name("guanglong", "liu"));
        c.add(new Integer(100));
        c.remove("hello");
        c.remove(new Integer(100));
        System.out.println(c.remove(new Name("guanglong", "liu")));
        System.out.println(c);
    }
}

class Name{
    private String firstName, lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Name){
            Name name = (Name) o;
            return (name.firstName.equals(this.firstName) && name.lastName.equals(this.lastName));
        }
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return this.firstName.hashCode();
    }
}