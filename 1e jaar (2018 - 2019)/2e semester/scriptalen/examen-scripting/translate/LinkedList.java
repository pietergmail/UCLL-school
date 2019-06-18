public class LinkedList {
	private Object value;
	private Object next;

	public LinkedList(Object value, Object next) {
		setValue(value);
		setNext(next);
	}

	private void setValue(Objecct value) {
		this.value = value;
	}

	private void setNext(Object next) {
		this.next = next;
	}

	public Object getValue() {
		return this.value;
	}

	public Object getNext() {
		return this.next;
	}

	public int getLength() {
		if(next == null) {
			return 1;
		}

		else {
			return 1 + getLength(next);
		}
	}

	public Object add(Object last) {
		if(next == null) {
			return new LinkedList(this, last);
		}

		else {
			return this.next.add(last);
		}
	}

	public boolean contains(Object value) {
		if(this.value.equals(value)) {
			return true;
		}

		if(this.next == null) {
			return false;
		}

		else {
			return this.next.contains(value);
		}
	}
}
