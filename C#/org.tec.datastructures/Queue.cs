using System;
namespace org.tec.datastructures
{
    public class Queue<T>
    {
        SimpleList<T> container = new SimpleList<T>();

        public void Push(T value){
            container.Append(value);
        }

        public T Peek(){
            return container.Get(0);
        }

        public T Pop(){
            T value = container.Get(0);
            container.Delete(0);
            return value;
        }

        public Boolean IsEmpty(){
            return container.IsEmpty();
        }
    }
}
