package org.example.server;

import org.example.resources.TestResource;

public class ResourceServer implements ResourceServerI{
    private TestResource res;

    public ResourceServer(TestResource res){
        this.res = res;
    }

    @Override
    public String getName() {
        return res.getName();
    }

    @Override
    public int getAge() {
        return res.getAge();
    }

    @Override
    public void setName(String name) {
        res.setName(name);
    }

    @Override
    public void setAge(int age) {
        res.setAge(age);
    }

    @Override
    public void setRes(TestResource t){
        res.setName(t.getName());
        res.setAge(t.getAge());
    }
}
