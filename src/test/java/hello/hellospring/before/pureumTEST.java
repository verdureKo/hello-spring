package hello.hellospring.before;

import org.junit.jupiter.api.Test;

import java.util.*;

class pureumTEST {

    @Test
    public void arr_for() {

        ArrayList<String> arr = new ArrayList<>() ;
        arr.add("A");
        arr.add("B");
        arr.add("C");
        arr.add("D");


        for( int j=0 ; j<10000000 ; j++){
            for( int i=0 ; i<arr.size() ; i++ ){
                String temp = arr.get(i);
            }
        }

    }

//    @Test
//    public void map_for() {
//        // 사용할 수 없다.
//    }


    @Test
    public void arr_for_in() {
        ArrayList<String> arr = new ArrayList<>() ;
        arr.add("A");
        arr.add("B");
        arr.add("C");
        arr.add("D");

        for( int j=0 ; j<10000000 ; j++){
            for( String element : arr ){
                String temp = element;
            }
        }

    }


//    @Test
//    public void map_for_in() {
//        HashMap<Integer, String> map = new HashMap<>();
//        map.put( 101 , "A" );
//        map.put( 102 , "B" );
//        map.put( 103 , "C" );
//        map.put( 104 , "D" );
//
//
//        for( int key : map.keySet() ){
//            String value = map.get(key);
//            System.out.println(value);
//        }
//
//        for( Map.Entry<Integer,String> entry : map.entrySet() ){
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
//    }




    @Test
    public void arr_forEach() {

        ArrayList<String> arr = new ArrayList<>() ;
        arr.add("A");
        arr.add("B");
        arr.add("C");
        arr.add("D");

        for( int i=0 ; i<10000000 ; i++){
            arr.forEach( element -> { String temp = element; } ) ;
        }
    }


//    @Test
//    public void map_forEach() {
//        HashMap<Integer, String> map = new HashMap<>();
//        map.put( 101 , "A" );
//        map.put( 102 , "B" );
//        map.put( 103 , "C" );
//        map.put( 104 , "D" );
//
//
//        map.keySet().forEach( key -> {
//            String value = map.get(key);
//            System.out.println(value);
//        });
//
//        map.entrySet().forEach( entry -> {
//            System.out.println("key : "+ entry.getKey() );
//            System.out.println("value : "+ entry.getValue() );
//        });
//    }



    @Test
    public void arr_iterator() {
        ArrayList<String> arr = new ArrayList<>() ;
        arr.add("A");
        arr.add("B");
        arr.add("C");
        arr.add("D");


        for( int i=0 ; i<10000000 ; i++){
            Iterator<String> it = arr.iterator();
            while(it.hasNext()){
                String temp = it.next();
            }
        }
    }


//    @Test
//    public void map_iterator() {
//        HashMap<Integer, String> map = new HashMap<>();
//        map.put( 101 , "A" );
//        map.put( 102 , "B" );
//        map.put( 103 , "C" );
//        map.put( 104 , "D" );
//
//
//        Iterator<Integer> it = map.keySet().iterator();
//        while( it.hasNext() ){
//            String value = map.get(it.next());
//            System.out.println(value);
//        }
//
//        Iterator<Map.Entry<Integer,String>> it2 = map.entrySet().iterator();
//        while( it2.hasNext() ){
//            Map.Entry<Integer,String> entry = it2.next();
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
//    }
















}
