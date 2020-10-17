package Lesson05Reflection.Lab.pr01_reflection;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<Reflection> aClass = Reflection.class;
        System.out.println("class " + aClass.getSimpleName());
        System.out.println(aClass.getSuperclass());

        Class[] interfaces = aClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Reflection ref = aClass.newInstance();
        System.out.println(ref);
    }
}
