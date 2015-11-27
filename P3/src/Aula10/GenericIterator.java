package Aula10;

public interface GenericIterator<T> {
		boolean hasNext();
		T next();
		void remove() throws Exception;
}
