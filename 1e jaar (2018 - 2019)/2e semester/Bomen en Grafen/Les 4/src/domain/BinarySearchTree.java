package domain;

public class BinarySearchTree<E extends Comparable<E>> {
	private BinaryTree<E> root;

	public void printInOrder() {
			if (this.isEmpty()) System.out.println("Geen data in BST");
			else root.printInOrder();
	}

	public boolean isEmpty(){
		return this.root == null;
	}

	public boolean lookup(E data){
			if (this.isEmpty()) return false;
			return root.lookup(data);
	}

    public void cleanup(){
        if (this.isEmpty()) System.out.println("Geen data in BST");
        else root.cleanUp();
    }

	public boolean addNode(E data){
		if (root == null) {
		    this.root = new BinaryTree<>(data);
		    return true;
        } else return this.root.addNode(data);
	}

	public boolean removeNode(E data){
		if (this.isEmpty()) return false;
		else {
			boolean ok = root.removeNode(data);
			if (ok && root.isEmpty()) root = null;
			return ok;
		}
	}

	public E searchSmallest(){
		if(this.isEmpty()) throw new IllegalStateException();
		return this.root.searchSmallest();
	}

	public int countNodes(){
	    if(this.isEmpty()) throw new IllegalStateException();
	    return this.root.countNodes();
    }

	public E searchGreatest(){
		if (this.isEmpty()) throw new IllegalStateException();
		return this.root.searchGreatest();
	}

	private class BinaryTree<E extends Comparable<E>>{
		private E data;
		private BinaryTree<E> leftTree, rightTree;

		public BinaryTree(E data){
			if (data == null) throw new IllegalArgumentException();
			this.data = data;
		}

		public void printInOrder(){
			if (leftTree != null) leftTree.printInOrder();
			System.out.print(" " + data);
			if (rightTree != null) rightTree.printInOrder();
		}

		public boolean isEmpty() {
			return false;
		}

		public boolean lookup(E data) {
            if (data == null) {
                return false;// er is geen data
            } else {
                if (data.compareTo(this.data) == 0) { //gezochte data is gelijk aan data
                    return true;// gevonde
                } else {
                    if (data.compareTo(this.data) < 0) {//gezochte data is kleiner dan data
                        if (leftTree == null) {//data bestaat niet
                            return false;
                        } else {
                            return leftTree.lookup(data);//verder zoeken in linker boom
                        }
                    }else {//gezochte data is niet gelijk of kleiner dus is hij groter
                        if (rightTree == null) {//data bestaat niet
                            return false;
                        }else {
                            return rightTree.lookup(data);//verder zoeken in rechter boom
                        }
                    }
                }
            }
		}
		public boolean addNode(E data){
            if (data == null){//check of data null is
                throw new IllegalArgumentException("data mag niet leeg zijn");

            } else {
                if (data.compareTo(this.data) == 0){//check of data al is voorgekomen
                    return false; //data is al voorgekomen
                } else if (data.compareTo(this.data) < 0){//nieuwe data is kleiner dan de huideige data
                    if (leftTree == null){//als lefttree leeg is nieuwe aanmaken
                        leftTree = new BinaryTree<>(data);
                        return true;
                    } else return this.leftTree.addNode(data);//anders functie herhalen op het linker lid
                } else {//het is niet kleiner of gelijk dus groter
                    if (rightTree == null){//als rightree leeg is nieuwe aanmaken
                        rightTree = new BinaryTree<>(data);
                    } else return this.rightTree.addNode(data);//anders functie herhalen op het rechter lid
                }
                return true;
            }
		}

		public boolean isLeaf(){
		    if (this.leftTree==null && this.rightTree == null){
		        return true;
            }
            return false;
        }


		public boolean removeNode(E data){
            if (data == null || this.data == null)
                return false;
            else if(data.compareTo(this.data) == 0){//juiste node gevonde
                if (this.isLeaf()){//checken of node een leaf is
                    this.data = null;
                }
            else if(this.leftTree != null){//left tree is niet leeg
                E grootsteLinks = leftTree.searchGreatest();
                this.data =  grootsteLinks;
                this.leftTree.removeNode(grootsteLinks);//herhaal met de linkerboom
            } else {//linker boom is leeg dus verder langs rechterboom
                E kleinsteRechts = rightTree.searchSmallest();
                this.data = kleinsteRechts;
                this.rightTree.removeNode(kleinsteRechts);//verder in rechterboom
            }
            return true;

            } else if (data.compareTo(this.data) < 0){//niet de juiste node gevonde
                if (this.leftTree == null)//data die gezocht wordt bestaat niet
                    return false;
                else//geszochte data bestaat
                    return this.leftTree.removeNode(data);//
            }else if (this.rightTree == null)//data die gezocht wordt bestaat niet
                return false;
            else
                return this.rightTree.removeNode(data);
        }

        public int countNodes(){
            return 1 + (this.leftTree == null ? 0 : this.leftTree.countNodes())
                    + (this.rightTree == null ? 0 : this.rightTree.countNodes());
        }


		public E searchGreatest() {
			if (rightTree == null){//grootste gevonde
			    return this.data;
            }
            return rightTree.searchGreatest();//verder lanks rechts zoeken
		}


		public E searchSmallest() {
			if (leftTree == null){//kleinste gevonde
			    return this.data;
            }
            return leftTree.searchSmallest();//verder zoeken lanks links
		}

        private void cleanUp(){//verwijder de null waardes uit de boom
            if (this.leftTree != null){//er is een left tree
                if (this.leftTree.data == null){//er is geen data in de left tree
                    this.leftTree = null;//verwijder node
                }else {
                    //ruim de linkerboom verder op
                    this.leftTree.cleanUp();
                }
            }
            if (this.rightTree != null){
                if (this.rightTree.data == null){//er is geen data in de left tree
                    this.rightTree = null;//verwijder node
                }else{
                    //ruim rechterboom verder op
                    this.rightTree.cleanUp();
                }
            }
        }

	}
}


