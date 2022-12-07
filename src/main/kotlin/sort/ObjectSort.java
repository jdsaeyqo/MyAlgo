package sort;

import java.util.*;

public class ObjectSort {

    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();
        Student[] arr = new Student[3];

        list.add(new Student(7,5));
        list.add(new Student(7,1));
        list.add(new Student(6,8));

        arr[0] = new Student(4,5);
        arr[1] = new Student(7,1);
        arr[2] = new Student(6,8);

        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.x != o2.x){
                    return o2.x - o1.x;
                }else {
                    return o1.y - o2.y;
                }

            }
        });

//        for(Student s : list){
//            System.out.print(s.x+" "+s.y);
//            System.out.println();
//        }

        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student(7,5));
        pq.add(new Student(5,2));
        pq.add(new Student(5,4));

        while (!pq.isEmpty()){
            Student s= pq.poll();
            System.out.print(s.x+" "+s.y);
            System.out.println();
        }

    }
}

class Student implements Comparable<Student>{
    int x;
    int y;

    Student(int x, int y){
        this.x = x;
        this.y = y;
    }


    @Override
    public int compareTo(Student s) {

        if(this.x != s.x){
            return this.x - s.x;
        }else{
            return s.y - this.y;
        }

    }
}
