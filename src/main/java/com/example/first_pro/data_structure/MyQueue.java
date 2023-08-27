package com.example.first_pro.data_structure;

import org.hibernate.loader.plan.spi.QuerySpaceUidNotRegisteredException;

public class MyQueue<T> {

  private Node first;
  private Node last;

  private static class Node<T> {
    private T data;
    private Node next;

    public Node(T data) {
      this.data = data;
    }
  }

  public void add(T data){
      Node newNode = new Node<>(data);
      if(last == null) {
          last = newNode;
          first = last;
      }else{
          last.next=newNode;
          last = newNode;
      }
  }

  public T peek(){
      if(first == null)throw new NullPointerException();
      T data = (T) first.data;
      first = first.next;
      return data;
  }

}
