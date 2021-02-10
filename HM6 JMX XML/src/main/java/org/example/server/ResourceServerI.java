package org.example.server;

import org.example.resources.TestResource;

public interface ResourceServerI {
    public String getName();
    public int getAge();
    public void setName(String name);
    public void setAge(int age);
    public void setRes(TestResource t);
}
