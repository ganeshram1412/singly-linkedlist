package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class SinglyLinkedList {

    private static final Logger logger = LoggerFactory.getLogger(SinglyLinkedList.class);

    Node head;
    Node current;

    void insertAtEnd(int element) {

        if (head == null) {
            head = new Node(element, null);
            current = head;
        } else {
            Node node = new Node(element, null);
            if (current == null) {
                current = head;
            }
            current.next = node;
            current = node;
        }
    }

    void insertAtBeginning(int element) {
        Node node = new Node(element, null);
        node.next = head;
        head = node;
    }

    void traverse() {
        Node temp = head;
        int counter = 0;
        while (temp != null) {
            logger.info("[index:{}, data {} pointer {} ", counter, temp.data, temp.next);

            counter++;
            temp = temp.next;
        }
    }

    void printHead() {
        logger.info("head ->> {}", head);
    }

    boolean insertAtIndex(int index, int data) {
        if (index == 0) {
            insertAtBeginning(data);
            return true;
        }
        if (index < 0) {
            logger.error("Index should be non-negative value");
            return false;
        } else {

            Node temp = head;
            int counter = 0;
            while (temp != null) {
                if (counter == index - 1) {
                    Node node = new Node(data, null);
                    node.next = temp.next;
                    temp.next = node;
                    return true;
                } else {
                    temp = temp.next;
                    counter++;

                }
            }
        }
        return false;
    }

    boolean deleteHead() {
        if (head == null) {
            logger.info("HEAD is null, cannot delete head");
            return false;
        } else {

            head = head.next;
            return true;
        }
    }

    boolean deleteAtEnd() {
        if (head == null) {
            logger.info("HEAD is null cannot delete last element");
            return false;
        } else {

            Node temp = head;

            while (temp != null) {
                if (temp.next != null) {
                    Node deletedNode = temp.next;
                    if (deletedNode.next == null) {
                        temp.next = null;
                        current = null;
                        break;

                    }
                }
                temp = temp.next;
            }
            return true;
        }
    }

    boolean deleteAtIndex(int index) {
        if (index == 0) {
            return deleteHead();
        } else {
            Node temp = head;
            Node previousNode = null;
            int counter = 0;
            while (temp != null) {
                if (counter == index) {
                    previousNode.next = temp.next;

                }
                counter++;
                previousNode = temp;
                temp = temp.next;
                current=temp;
            }
        }
        return true;

    }

    void deleteElement(int element) {
        Node temp = head;
        Node previousNode = null;
        while (temp != null) {
            if (temp.data == element && temp.next != null) {
                previousNode.next = temp.next;
            }
            previousNode = temp;
            temp = temp.next;
        }
    }

    static void printOperations() {
        logger.info("Singly Linked List Menu Choose operation between 1 to 9");
        logger.info("1. Add an element at end");
        logger.info("2. Print Linked list");
        logger.info("3. Add an element at beginning");
        logger.info("4. Add element at index");
        logger.info("5. Delete head element");
        logger.info("6. Delete last element");
        logger.info("7. Delete element at Index");
        logger.info("8. Exit Linked List operation");
        logger.info("9. Show all Linked List operation option");
    }

    public static void init() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Scanner scanner = new Scanner(System.in);
        String choice;
        printOperations();
        do {
            logger.info("Singly Linked List Menu Choose operation between 1 to 9");

            String element;
            choice = scanner.next();

            switch (choice) {
                case "1":
                    logger.info("Enter integer to be added at end of linked list");
                    element = scanner.next();
                    try {

                        int data = Integer.parseInt(element);
                        singlyLinkedList.insertAtEnd(data);
                        logger.info("Successfully added element {} to linked list", data);

                    } catch (NumberFormatException e) {
                        logger.error("Enter valid integer. This is an invalid integer {}", element);
                    }
                    break;
                case "2":
                    singlyLinkedList.traverse();
                    logger.info("Successfully printed all elements in linked list");

                    break;
                case "3":
                    logger.info("Enter integer to be added at beginning of singly linked list");
                    element = scanner.next();
                    try {
                        int data = Integer.parseInt(element);
                        singlyLinkedList.insertAtBeginning(data);
                        logger.info("Successfully added element at beginning of  linked list");

                    } catch (NumberFormatException e) {
                        logger.error("Enter valid integer. This is an invalid integer {}", element);
                    }
                    break;
                case "4":
                    logger.info("Enter integer value to be added at specified index");
                    element = scanner.next();
                    logger.info("Enter index to be added in linked list");
                    String index = scanner.next();
                    try {
                        int data = Integer.parseInt(element);
                        int indexValue = Integer.parseInt(index);
                        if (singlyLinkedList.insertAtIndex(indexValue, data)) {
                            logger.info("Successfully added element at  index {} of  linked list", indexValue);

                        } else {
                            logger.error("Error occured while entering at index {}. Please check index value",
                                    indexValue);
                        }

                    } catch (NumberFormatException e) {
                        logger.error("Enter valid integer. This is an invalid integer {}", element);
                    }
                    break;
                case "5":
                    if (singlyLinkedList.deleteHead()) {
                        logger.info("Successfully deleted head element");

                    }
                    break;
                case "6":
                    if (singlyLinkedList.deleteAtEnd()) {
                        logger.info("Successfully deleted last element");

                    }
                    break;
                case "7":
                    logger.info("Enter index of element to be deleted in linked list");
                    element = scanner.next();
                    try {
                        int indexValue = Integer.parseInt(element);
                        singlyLinkedList.deleteAtIndex(indexValue);
                        logger.info("Successfully deleted element at specified index of  linked list");

                    } catch (NumberFormatException e) {
                        logger.error("Enter valid integer. This is an invalid integer {}", element);
                    }
                    break;
                case "8":
                    logger.info("Exiting application");
                    System.exit(0);
                    break;
                case "9":
                    printOperations();
                    break;
                default:
                    logger.info("Please enter valid option. Integer value between 1 to 9");
            }

        } while (!choice.equals("9"));
    }
}
