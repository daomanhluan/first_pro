package com.example.first_pro.data_structure;

import java.util.EmptyStackException;

public class MyStack<T> {

  private Node top;

  private static class Node<T> {
    private T data;
    private Node next;

    public Node(T data) {
      this.data = data;
    }
  }

  public void push(T data) {
    Node newNode = new Node(data);
    newNode.next = top;
    top = newNode;
  }

  public T pop(){
      if(top == null) throw new EmptyStackException();
      T data = (T) top.data;
      top = top.next;
      return data;
  }
}
