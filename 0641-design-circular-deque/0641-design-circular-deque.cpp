class MyCircularDeque {
private:
    vector<int> data;
    int head;
    int tail;
    int size;
    int capacity;

public:
    MyCircularDeque(int k) {
        data.resize(k);
        head = 0;
        tail = k - 1;
        size = 0;
        capacity = k;
    }

    bool insertFront(int value) {
        if (isFull()) return false;
        head = (head - 1 + capacity) % capacity;
        data[head] = value;
        size++;
        return true;
    }

    bool insertLast(int value) {
        if (isFull()) return false;
        tail = (tail + 1) % capacity;
        data[tail] = value;
        size++;
        return true;
    }

    bool deleteFront() {
        if (isEmpty()) return false;
        head = (head + 1) % capacity;
        size--;
        return true;
    }

    bool deleteLast() {
        if (isEmpty()) return false;
        tail = (tail - 1 + capacity) % capacity;
        size--;
        return true;
    }

    int getFront() {
        if (isEmpty()) return -1;
        return data[head];
    }

    int getRear() {
        if (isEmpty()) return -1;
        return data[tail];
    }

    bool isEmpty() {
        return size == 0;
    }

    bool isFull() {
        return size == capacity;
    }
};
