package customiterator;

import customiterator.exceptions.NextElementHasNotException;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.function.Consumer;

public class CustomArrayIterator<T> implements Iterator<T> {
    private static final int NULL_INDEX = -999;
    private static final int BEGIN_POSITION = 0;

    private final T[][] arrays;
    private T next;
    private int currentArray = NULL_INDEX;
    private int currentPositionInCurrentArray = NULL_INDEX;

    public CustomArrayIterator(T[][] arrays) {
        this.arrays = arrays;
        setBeginPosition();
    }

    private void setBeginPosition(){
        if (this.arrays != null && this.arrays.length != 0){
            int currentArrayTmp = BEGIN_POSITION;
            while (this.currentArray == NULL_INDEX
                    && this.currentPositionInCurrentArray == NULL_INDEX){
                if (this.arrays[currentArrayTmp].length != 0){
                    this.currentArray = currentArrayTmp;
                    this.currentPositionInCurrentArray = BEGIN_POSITION;
                    this.next = this.arrays[this.currentArray][currentPositionInCurrentArray];
                }
                currentArrayTmp += 1;
                if (currentArrayTmp == this.arrays.length){
                    return;
                }
            }
        }
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    @NotNull
    public T next() {
        if (next != null) {
            T oldNext = next;
            setNewNext();
            return oldNext;
        }

        throw new NextElementHasNotException();
    }

    private void setNewNext(){
        if (hasNextPositionInCurrentArray()){
            currentPositionInCurrentArray += 1;
            next = arrays[currentArray][currentPositionInCurrentArray];
            return;
        }
        int currentArrayTmp = currentArray + 1;
        while (currentArrayTmp < arrays.length){
            if (this.arrays[currentArrayTmp].length != 0){
                currentArray = currentArrayTmp;
                currentPositionInCurrentArray = 0;
                next = arrays[currentArray][currentPositionInCurrentArray];
                return;
            }
            currentArrayTmp += 1;
        }

        next = null;
    }

    private boolean hasNextPositionInCurrentArray(){
        int nextPositionInCurrentArray = currentPositionInCurrentArray + 1;
        return nextPositionInCurrentArray < this.arrays[currentArray].length;
    }

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {

    }
}
