package org.example.server;

public class ResourceServerController implements ResourceServerControllerMBean{
    private final ResourceServerI res;

    public ResourceServerController(ResourceServerI res) {
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
}
