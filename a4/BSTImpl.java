package a4;

import java.util.ArrayList;

public class BSTImpl implements BSTInterface {

    // Class BSTNode for the nodes of the tree
    private static class BSTNode{

        // variable to store the item of the node
        private int item;

        // variable to point to the left node
        private BSTNode left;

        // variable to point to the right node
        private BSTNode right;

        // variable to help inorder traversing
        private boolean done1;

        // variable to help preorder traversing
        private boolean done2;

        // variable to help postorder traversing
        private boolean done3;

        // public constructor to initialize all the variables of the node
        public BSTNode(int item, BSTNode left, BSTNode right, boolean done1, boolean done2, boolean done3){
            this.item = item;
            this.left = left;
            this.right = right;
            this.done1 = done1;
            this.done2 = done2;
            this.done3 = done3;
        }

        // returns the item of the node
        public int getItem() {
            return item;
        }

        // returns the node to the left of the current node
        public BSTNode getLeft() {
            return left;
        }

        // returns the node to the right of the current node
        public BSTNode getRight() {
            return right;
        }

        // sets the pointer to the left node of the node
        public void setLeft(BSTNode left) {
            this.left = left;
        }

        // sets the pointer to the right node of the node
        public void setRight(BSTNode right) {
            this.right = right;
        }

        // sets the value of the boolean
        public void setDone1(boolean done1) {
            this.done1 = done1;
        }

        // sets the value of the boolean
        public void setDone2(boolean done2) {
            this.done2 = done2;
        }

        // sets the value of the boolean
        public void setDone3(boolean done3) {
            this.done3 = done3;
        }
    }

    // variable to point to the root of the tree
    private BSTNode root;

    // variable to hold the current node to for the inorder traversal
    private BSTNode currentNode1;

    // variable to hold the current node to for the preorder traversal
    private BSTNode currentNode2;

    // variable to hold the current node to for the postorder traversal
    private BSTNode currentNode3;

    // variable to hold the start node for the inorder traversal
    private BSTNode start1;

    // variable to hold the start node for the preorder traversal
    private BSTNode start2;

    // variable to hold the start node for the postorder traversal
    private BSTNode start3;

    // variable to hold the size of the tree
    private int size;

    // variable to hold the item for the inorder traversal
    private int item1;

    // variable to hold the item for the preorder traversal
    private int item2;

    // variable to hold the item for the postorder traversal
    private int item3;

    // counter used in the preorder traversal
    private int counter = 0;

    // no argument constructor
    public BSTImpl(){
    }

    // gets the size of the tree
    public int getSize(){
        return this.size;
    }

    // checks of the tree is empty
    @Override
    public boolean isEmpty() {
        if(this.size == 0) {
            return true;
        }
        else{
            return false;
        }
    }

    // checks to see if the value already exists in the tree
    public boolean contains(BSTNode root, int value) {
        if (root == null) {
            return false;
        }
        if (root.getItem() == value) {
            return true;
        }
        if (value < root.getItem()) {
            return contains(root.getLeft(), value);
        } else {
            return contains(root.getRight(), value);
        }
    }

    // inserts an integer into the tree
    @Override
    public void insert(Comparable item) {

        // if the tree is empty, create a new BSTNode
        if(this.root == null){

            // only add the item if it's the first item and set everything else null or false
            this.root = new BSTNode((int)item, null, null, false, false, false);

            // increment the size
            size++;
        }

        // checks to see if the value is in the BST
        else if(contains(root, (int)item)){
            throw new IllegalArgumentException("Value already exists in the BST");
        }

        // else add
        else{

            // temp is equal to the root
            BSTNode temp = root;

            // set the boolean to true
            boolean c = true;

            // the loop will run as long as c is true
            while(c == true){

                // if item is less than temp
                if(item.compareTo(temp.getItem()) < 0){

                    // if the left of temp is null then add the node to the tree
                    if(temp.getLeft() == null){
                        BSTNode t = new BSTNode((int)item, null, null, false,
                                false, false);
                        temp.setLeft(t);
                        size++;
                        c = false;
                    }

                    // else move to the left of temp
                    else{
                        temp = temp.getLeft();
                    }
                }

                // if item is greater than temp
                else{

                    // if the right of temp is null then add the node to the tree
                    if(temp.getRight() == null){
                        BSTNode t = new BSTNode((int)item, null, null, false,
                                false, false);
                        temp.setRight(t);
                        size++;
                        c = false;
                    }

                    // else move to the right of temp
                    else{
                        temp = temp.getRight();
                    }
                }
            }
        }
    }

    // gets the next item of the tree based on the order type of the traversal
    @Override
    public Comparable getNextItem(int orderType) {

        // if invalid order type, then throw an exception
        if(orderType > 3 || orderType < 1){
            throw new IllegalArgumentException("Incorrect order type");
        }

        // else
        else {

            // if the size is one, then return the root
            if (this.size == 1) {
                return root.getItem();
            }

            // if order type is 1, then an inorder traversal
            else if (orderType == 1) {
                if (currentNode1.getItem() == iterMax() && currentNode1.done1) {
                    currentNode1 = start1;
                    resetBoolean(root, 1);
                }
                if (currentNode1.getLeft() != null && currentNode1.getLeft().done1 == false) {
                    while (currentNode1.getLeft() != null && !currentNode1.getLeft().done1) {
                        currentNode1 = currentNode1.getLeft();
                    }
                    currentNode1.done1 = true;
                    item1 = currentNode1.getItem();
                    return item1;
                } else if (!currentNode1.done1) {
                    item1 = currentNode1.getItem();
                    currentNode1.done1 = true;
                    if (currentNode1.getRight() != null && !currentNode1.getRight().done1) {
                        currentNode1 = currentNode1.getRight();
                    }
                    return item1;
                } else if (currentNode1.getRight() != null && !currentNode1.getRight().done1) {
                    if (currentNode1.getLeft() != null && currentNode1.getLeft().done1 == false) {
                        while (currentNode1.getLeft() != null && !currentNode1.getLeft().done1) {
                            currentNode1 = currentNode1.getLeft();
                        }
                        currentNode1.done1 = true;
                        item1 = currentNode1.getItem();
                        return item1;
                    } else if (!currentNode1.done1) {
                        item1 = currentNode1.getItem();
                        currentNode1.done1 = true;
                        return item1;
                    } else {
                        while ((currentNode1.getLeft() == null || currentNode1.getLeft().done1) &&
                                currentNode1.getRight() != null && !currentNode1.getRight().done1) {
                            currentNode1 = currentNode1.getRight();
                        }
                        if (currentNode1.getLeft() != null && !currentNode1.done1) {
                            getNextItem(1);
                        }
                        currentNode1.done1 = true;
                        item1 = currentNode1.getItem();
                        return item1;
                    }
                } else {
                    while (true) {
                        currentNode1 = getParent(currentNode1, 1);
                        if (currentNode1.getLeft() != null && !currentNode1.getLeft().done1 ||
                                currentNode1.getRight() != null && !currentNode1.getRight().done1) {
                            break;
                        }
                    }
                    getNextItem(1);
                }
                return item1;
            }

            // if order type is 2, then a preorder traversal
            else if (orderType == 2) {
                if (counter == size) {
                    currentNode2 = start2;
                    resetBoolean(root, 2);
                }
                if (!currentNode2.done2) {
                    item2 = currentNode2.getItem();
                    currentNode2.done2 = true;
                    counter++;
                    return item2;
                } else {
                    if (currentNode2.getLeft() != null && !currentNode2.getLeft().done2) {
                        currentNode2 = currentNode2.getLeft();
                        item2 = currentNode2.getItem();
                        currentNode2.done2 = true;
                        counter++;
                        return item2;
                    } else if (currentNode2.getRight() != null && !currentNode2.getRight().done2) {
                        currentNode2 = currentNode2.getRight();
                        item2 = currentNode2.getItem();
                        currentNode2.done2 = true;
                        counter++;
                        return item2;
                    } else {
                        while (true) {
                            currentNode2 = getParent(currentNode2, 2);
                            if (currentNode2.getLeft() != null && !currentNode2.getLeft().done2 ||
                                    currentNode2.getRight() != null && !currentNode2.getRight().done2) {
                                break;
                            }
                        }
                        getNextItem(2);
                    }
                }
                return item2;
            }

            // if order type is 3, then a postorder traversal
            else {
                if (this.root.done3) {
                    currentNode3 = start3;
                    resetBoolean(root, 3);
                }
                if (root.getRight() != null && root.getRight().done3 && !root.done3) {
                    currentNode3 = root;
                    item3 = currentNode3.getItem();
                    currentNode3.done3 = true;
                    return item3;
                } else if (currentNode3.getLeft() != null && currentNode3.getLeft().done3 == false) {
                    while (currentNode3.getLeft() != null && !currentNode3.getLeft().done3) {
                        currentNode3 = currentNode3.getLeft();
                    }
                    if (currentNode3.getRight() != null && !currentNode3.getRight().done3) {
                        getNextItem(3);
                    }
                    currentNode3.done3 = true;
                    item3 = currentNode3.getItem();
                    return item3;
                } else if (currentNode3.getRight() != null && !currentNode3.getRight().done3) {
                    if (currentNode3.getLeft() != null && currentNode3.getLeft().done3 == false) {
                        while (currentNode3.getLeft() != null && !currentNode3.getLeft().done3) {
                            currentNode3 = currentNode3.getLeft();
                        }
                        if ((currentNode3.getRight() != null && !currentNode3.getRight().done3) ||
                                currentNode3.getLeft() != null && currentNode3.getLeft().done3 == false) {
                            getNextItem(3);
                        }
                        currentNode3.done3 = true;
                        item3 = currentNode3.getItem();
                        return item3;
                    } else if (currentNode3.getRight() != null && !currentNode3.getRight().done3) {
                        while ((currentNode3.getLeft() == null || currentNode3.getLeft().done3) &&
                                currentNode3.getRight() != null && !currentNode3.getRight().done3) {
                            currentNode3 = currentNode3.getRight();
                        }
                        if ((currentNode3.getRight() != null && !currentNode3.getRight().done3) ||
                                (currentNode3.getLeft() != null && !currentNode3.getLeft().done3)) {
                            getNextItem(3);
                        }
                        currentNode3.done3 = true;
                        item3 = currentNode3.getItem();
                        return item3;
                    } else {
                        item3 = currentNode3.getItem();
                        currentNode3.done3 = true;
                        return item3;
                    }
                } else if (!currentNode3.done3) {
                    item3 = currentNode3.getItem();
                    currentNode3.done3 = true;
                    if (currentNode3.getRight() != null && !currentNode3.done3) {
                        currentNode3 = currentNode3.getRight();
                    }
                    return item3;
                } else {
                    while (true) {
                        currentNode3 = getParent(currentNode3, 3);
                        if (currentNode3.getLeft() != null && !currentNode3.getLeft().done3 ||
                                currentNode3.getRight() != null && !currentNode3.getRight().done3) {
                            break;
                        }
                    }
                    getNextItem(3);
                }
                return item3;
            }
        }
    }

    // checks if the node has children
    public boolean hasChildren(BSTNode node){
        return node != null && (node.getLeft() != null || node.getRight() != null);
    }

    // returns the parent node of a node based on the order type
    public BSTNode getParent(BSTNode node, int ordertype){
        int prevItem = node.getItem();
        BSTNode temp;
        boolean condition = true;

        if((ordertype == 2) && ((root.getLeft().getItem() == prevItem ||
                root.getRight().getItem() == prevItem) && root.done2)){
            condition = false;
            temp = this.root;
        }
        else if((ordertype == 1  || ordertype == 3) && ((root.getLeft().getItem() == prevItem ||
                root.getRight().getItem() == prevItem) && (!root.done1 || !root.done3))){
            condition = false;
            temp = this.root;
        }
        else if(prevItem > this.root.getItem()){
            temp = this.root.getRight();
        }
        else{
            temp = this.root.getLeft();
        }
        while (condition) {
            if (((temp.getLeft() != null && temp.getLeft().getItem() == prevItem) ||
                    (temp.getRight() != null && temp.getRight().getItem() == prevItem))) {
                break;
            }
            if (temp.getItem() < prevItem && temp.getRight() != null) {
                temp = temp.getRight();
            } else {
                if(temp.getLeft() != null) {
                    temp = temp.getLeft();
                }
            }
        }

        return temp;
    }

    // resets the pointer of the tree to the start based on the order type
    @Override
    public void reset(int orderType) {
        if(orderType > 3 || orderType < 1){
            throw new IllegalArgumentException("Incorrect order type");
        }
        else {
            if(this.size >= 1) {
                if (orderType == 1) {
                    currentNode1 = root;
                    while (currentNode1.getLeft() != null) {
                        currentNode1 = currentNode1.getLeft();
                    }
                    this.start1 = currentNode1;
                } else {
                    if (orderType == 2) {
                        currentNode2 = this.root;
                        this.start2 = currentNode2;
                    } else {
                        currentNode3 = root;
                        while (currentNode3.getLeft() != null) {
                            currentNode3 = currentNode3.getLeft();
                        }
                        if (currentNode3.getRight() != null) {
                            currentNode3 = currentNode3.getRight();
                        }
                        this.start3 = currentNode3;
                    }
                }
            }
        }
    }

    // resets all the done boolean for each node in the tree
    public void resetBoolean(BSTNode node, int ordertype){
        if (node == null) {
            return;
        }
        if(ordertype == 1){
            node.setDone1(false);
        }
        else if(ordertype == 2){
            node.setDone2(false);
        }
        else{
            node.setDone3(false);
        }
        resetBoolean(node.getLeft(), ordertype);
        resetBoolean(node.getRight(), ordertype);
    }

    // iterates through the tree and returns the largest int
    public int iterMax(){
        BSTNode temp = root;
        if(temp.getRight() != null) {
            while (temp.getRight() != null) {
                temp = temp.getRight();
            }
            return temp.getItem();
        }
        else{
            return root.getItem();
        }
    }

    // recursively returns the largest int in the tree
    public int recMax(){
        BSTNode temp = root;
        if(temp.getRight() != null){
            temp = recursiveMax(temp);
            return temp.getItem();
        }
        else{
            return root.getItem();
        }
    }

    // method for the recursion of the recMax method
    private BSTNode recursiveMax(BSTNode temp){
        if(temp.getRight() == null){
            return temp;
        }
        else{
            return recursiveMax(temp.getRight());
        }
    }

    // method to return the node with the largest int in the tree
    private BSTNode max(){
        BSTNode temp = root;
        while(temp.getRight() != null){
            temp = temp.getRight();
        }
        return temp;
    }

    // method to return an arraylist of all the values of nodes under a node (children of a node)
    public void t(BSTNode node, ArrayList a) {
        if (node != null) {
            a.add(node.getItem());
            t(node.getLeft(), a);
            t(node.getRight(), a);
        }
    }

    // method to return the largest int in the tree and delete that node
    public int deleteMax(){

        BSTNode temp = max();
        int n = temp.getItem();
        BSTNode r = root;

        if(root.getRight() != null) {
            while (r.getRight() != temp) {
                r = r.getRight();
            }
        }
        else{
            root = root.getLeft();
        }

        if(!hasChildren(temp)){
            r.setRight(null);
        }
        else if(temp.getRight() != null && temp.getLeft() == null){
            r.setRight(temp.getRight());
        }
        else if(temp.getLeft() != null && temp.getRight() == null){
            r.setRight(temp.getLeft());
        }
        else if(temp.getRight() != null && temp.getLeft() != null){
            r.setRight(temp.getLeft());
            ArrayList<Integer> a = new ArrayList<>();
            t(temp.getLeft().getLeft(), a);
            t(temp.getLeft().getRight(), a);
            r.getRight().setRight(temp.getRight());

            for(int i = 0; i < a.size(); i++){
                this.insert(a.get(i));
            }

        }

        return n;
    }

}
