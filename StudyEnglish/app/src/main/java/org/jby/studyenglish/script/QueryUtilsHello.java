package org.jby.studyenglish.script;

import java.util.ArrayList;

public class QueryUtilsHello {


    private QueryUtilsHello(){

    }

    public static ArrayList<Helloo> extractHellos(){

        ArrayList<Helloo> hellos = new ArrayList<>();

        hellos.add(new Helloo("what is this?", "이것은 무엇입니까?"));

        return hellos;
    }
}
