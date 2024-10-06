package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

 private SinglyLinkedList singlyLinkedList;

 @BeforeEach
 void setUp() {
  singlyLinkedList = new SinglyLinkedList();
 }

 @Test
 void testInsertAtEnd() {
  singlyLinkedList.insertAtEnd(10);
  singlyLinkedList.insertAtEnd(20);
  singlyLinkedList.insertAtEnd(30);

  assertTrue(singlyLinkedList.traverse());
 }

 @Test
 void testInsertAtBeginning() {
  singlyLinkedList.insertAtBeginning(10);
  singlyLinkedList.insertAtBeginning(20);

  assertEquals(20, singlyLinkedList.head.data); // Head should be 20
 }

 @Test
 void testInsertAtIndexValid() {
  singlyLinkedList.insertAtEnd(10);
  singlyLinkedList.insertAtEnd(20);
  singlyLinkedList.insertAtEnd(30);

  assertTrue(singlyLinkedList.insertAtIndex(1, 15)); // Insert at valid index 1

  // Expected sequence: 10 -> 15 -> 20 -> 30
  assertEquals(15, singlyLinkedList.head.next.data);
 }

 @Test
 void testInsertAtIndexInvalid() {
  singlyLinkedList.insertAtEnd(10);

  assertFalse(singlyLinkedList.insertAtIndex(-1, 5)); // Invalid index
  assertTrue(singlyLinkedList.insertAtIndex(5, 20)); // Index exceeds size, insert at end
 }

 @Test
 void testDeleteHeadWhenEmpty() {
  assertFalse(singlyLinkedList.deleteHead()); // No elements to delete
 }

 @Test
 void testDeleteHead() {
  singlyLinkedList.insertAtEnd(10);
  singlyLinkedList.insertAtEnd(20);

  assertTrue(singlyLinkedList.deleteHead());
  assertEquals(20, singlyLinkedList.head.data); // Head should now be 20
 }

 @Test
 void testDeleteAtEndWhenEmpty() {
  assertFalse(singlyLinkedList.deleteAtEnd());
 }

 @Test
 void testDeleteAtEnd() {
  singlyLinkedList.insertAtEnd(10);
  singlyLinkedList.insertAtEnd(20);
  singlyLinkedList.insertAtEnd(30);

  assertTrue(singlyLinkedList.deleteAtEnd());
  assertNull(singlyLinkedList.head.next.next); // Last element should be null
 }

 @Test
 void testDeleteAtIndexValid() {
  singlyLinkedList.insertAtEnd(10);
  singlyLinkedList.insertAtEnd(20);
  singlyLinkedList.insertAtEnd(30);

  assertTrue(singlyLinkedList.deleteAtIndex(1)); // Delete element at index 1 (20)

  assertEquals(30, singlyLinkedList.head.next.data); // 10 -> 30
 }

 @Test
 void testDeleteAtIndexInvalid() {
  singlyLinkedList.insertAtEnd(10);

  assertFalse(singlyLinkedList.deleteAtIndex(5)); // Invalid index
 }

 @Test
 void testDeleteElementValid() {
  singlyLinkedList.insertAtEnd(10);
  singlyLinkedList.insertAtEnd(20);
  singlyLinkedList.insertAtEnd(30);

  singlyLinkedList.deleteElement(20);

  assertEquals(30, singlyLinkedList.head.next.data); // 10 -> 30
 }

 @Test
 void testDeleteElementInvalid() {
  singlyLinkedList.insertAtEnd(10);
  singlyLinkedList.insertAtEnd(20);

  singlyLinkedList.deleteElement(50); // Element not in the list

  assertEquals(10, singlyLinkedList.head.data); // No change in list
  assertEquals(20, singlyLinkedList.head.next.data);
 }

 @Test
 void testTraverseEmptyList() {
  assertTrue(singlyLinkedList.traverse()); // Empty list traversal
 }

 @Test
 void testTraverseNonEmptyList() {
  singlyLinkedList.insertAtEnd(10);
  singlyLinkedList.insertAtEnd(20);

  assertTrue(singlyLinkedList.traverse()); // Should traverse successfully
 }
}
