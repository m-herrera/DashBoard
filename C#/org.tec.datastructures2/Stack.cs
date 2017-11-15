using System;
namespace org.tec.datastructures
{
    public class Stack<T>
    {
        SimpleList<T> container = new SimpleList<T>();

        public void Push(T value){
            container.Append(value);
        }

        public T Peek(){
            return container.Get(container.Length() - 1);
        }

        public T Pop(){
            T value = container.Get(container.Length() - 1);
            container.Delete(container.Length() - 1);
            return value;
        }

        public Boolean IsEmpty(){
            return container.IsEmpty();
        }
    }
}
