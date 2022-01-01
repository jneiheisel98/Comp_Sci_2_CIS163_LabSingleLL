package linkedlistlab;

public class LinkListLab {
    private Node top;
    private Node tail;

    public LinkListLab() {
        top = null;
        tail = null;
    }

    /****************************************************************
     *
     * Determines the size, that is, the number of elements in the list
     *
     * @return  the size of the list
     *
     ****************************************************************/
    public int getLen() {
        int counter = 0;
        Node temp = top;
        if(temp == null){
            return counter;
        }
        counter++;
        while (temp.getNext() != null){
            counter++;
            temp = temp.getNext();
        }
        return counter;
    }

    /****************************************************************
     *
     * Inserts a node before a specific index.  When the list is empty
     * that is, top = null, then the index must be 0. After the first
     * element is added, index must be:  0 <= index < size of list
     *
     * @param index a specific index into the list.
     *
     * @throws MyIllegalArgumentException if index < 0 or
     *           index >= size of the list

     ****************************************************************/

    public void insertBefore (int index, String data) {
        Node temp = top;
        if(temp == null && index ==0){
            tail = top = new Node(data, null);
        }
        else if(temp == null && index > 0){
            throw new MyIllegalArgumentException();
        }

        else if(temp != null && index > 0 && index < getLen()){
            int tempCounter = index;
            while (tempCounter >1){
                temp = temp.getNext();
                tempCounter--;
            }
            temp.setNext(new Node(data, temp.getNext()));
        }
        else if(temp != null && index == 0){
            if(top == tail) {
                top = new Node(data, top);
                tail = top.getNext();
            }
            else{
                top = new Node(data, top);
            }



        }
        else{
            throw new MyIllegalArgumentException();
        }
    }

    /****************************************************************
     *
     * Inserts a node after a specific index.  When the list is empty
     * that is, top = null, then the index must be 0. After the first
     * element is added, index must be:  0 <= index < size of list
     *
     * @param index a specific index into the list.
     *
     * @throws MyIllegalArgumentException if index < 0 or
     *           index >= size of the list

     ****************************************************************/

    public void insertAfter (int index, String data) {
        Node temp = top;
        if(temp == null && index ==0){
            top = new Node(data, null);
        }
        else if(temp == null && index > 0){
            throw new MyIllegalArgumentException();
        }
        else if( temp.getNext() == null && index == 0 && temp !=null){
            temp.setNext(new Node(data, null));
        }
        else if( temp.getNext() != null && index == 0 && temp !=null){
            temp.setNext(new Node(data, temp.getNext()));
        }


        else if(temp != null && index > 0 && index < getLen()){
            int tempCounter = index;
            while (tempCounter >0){
                temp = temp.getNext();
                tempCounter--;
            }
            if(index == getLen()-1){
                temp.setNext(new Node(data, temp.getNext()));
                tail = temp.getNext();
            }
            else {
                temp.setNext(new Node(data, temp.getNext()));
            }
        }

        else{
            throw new MyIllegalArgumentException();
        }
    }


    /****************************************************************
     *
     * Removes the top element of the list
     *
     * @return returns the element that was removed.
     *
     * @throws MyIllegalArgumentException if top == null, that is,
     *            there is no list.
     *
     ****************************************************************/

    public String removeTop () {
       Node temp = top;
       String removed = null;
       if(temp ==null){
           throw new MyIllegalArgumentException();
       }
       else if(temp !=null){
           removed = temp.getData();
           top = temp.getNext();
       }
        return removed;
    }


    /****************************************************************
     *
     * This Method removes a node at the specific index position.  The
     * first node is index 0.
     *
     * @param index the position in the linked list that is to be
     *           removed.  The first position is zero.
     *
     * @throws MyIllegalArgumentException if index < 0 or
     *           index >= size of the list
     *
     ****************************************************************/
    public String delAt(int index) {
        String temp = null;
        Node temporaryNode = top;
        if(index<0 || index >= getLen()){
            throw new MyIllegalArgumentException();


        }

       else if (index ==0 && temporaryNode !=null){
           temp = temporaryNode.getData();
           top = temporaryNode.getNext();
        }
        else if (index ==0 && temporaryNode ==null){
           throw new MyIllegalArgumentException();
        }
        else{
            int tempCounter = index;
            while (tempCounter >1){
                temporaryNode = temporaryNode.getNext();
                tempCounter--;
            }
            if(temporaryNode.getNext().getNext() == null){
                tail = temporaryNode;
            }
            temp = temporaryNode.getNext().getData();
            temporaryNode.setNext(temporaryNode.getNext().getNext());
        }
        return temp;
    }

// A simple testing program.  Not complete but a good start.

    public static void main (String[] args){
        LinkListLab list = new LinkListLab();

        list.display();
        System.out.println ("Current length = " + list.getLen());

        list.insertBefore(0, "apple");
        list.insertBefore(0, "pear");
        list.insertBefore(1, "peach");
        list.insertBefore(1, "cherry");
        list.insertBefore(3, "donut");
        list.display();

        list.insertAfter(4, "apple");
        list.insertAfter(0, "pear");
        list.insertAfter(1, "peach");
        list.insertAfter(1, "cherry");
        list.insertAfter(3, "donut");
        list.display();

        list.removeTop();
        System.out.println("Deleted pos 4 with value of: " +list.delAt(4));
        System.out.println("Deleted pos 2 with value of: " +list.delAt(2));
        System.out.println("Deleted pos 0 with value of: " +list.delAt(0));
        list.display();
        list.removeTop();
        list.removeTop();

        list.display();
    }

    public void display() {
        Node temp = top;

        System.out.println ("___________ List ________________________");
        while (temp != null) {
            System.out.println (temp.getData());
            temp = temp.getNext();
        }
    }
}

