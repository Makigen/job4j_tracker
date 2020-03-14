package oop;

public class JSONReport extends TextReport {
    @Override
    public String generate(String name, String body) {
        return "name: " + name + '\n' + "body: " + body;
    }
}
