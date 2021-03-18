package com.example.webbrowser;

public class URLLinkedlList {
    Node head;
    Node tail;
    Node current;
    int size;

    URLLinkedlList(){
        size = 0;
    }
    public void insert(String url){
        if(getSize() < 1){
            current = new Node(url);
            current.next = tail;
            current.previous = head;
        } else {
           Node nextCurrent = new Node(url);
           Node previous = current.previous;
           nextCurrent.next = current;
           current.previous = nextCurrent;
           nextCurrent.previous = previous;
           if(previous != null){previous.next = nextCurrent;}
           current = nextCurrent;
        }
        size++;
    }

    public class Node {
        Node previous;
        Node next;
        String url;
        Node(String url){
            this.url = url;

        }
    }
    public int getSize(){
        return this.size;
    }

    public boolean checkTail(){
        return current.next != null && current != null;
    }
    public boolean checkHead(){
        return current.previous != null && current != null;
    }
    public String back(){
        current = current.next;
        return current.url;
    }
    public String forward(){
        current = current.previous;
        return current.url;
    }
}
