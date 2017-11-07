using System;
namespace org.tec.datastructures
{
    public class SimpleList<T>
    {
        Node<T> head;
        public void Append(T value)
        {
            if (head == null)
            {
                head = new Node<T>(value);
            }
            else
            {
                Node<T> nodo = head;
                while (nodo.GetNext() != null)
                {
                    nodo = nodo.GetNext();
                }

                nodo.SetNext(new Node<T>(value));

            }
        }

        public void Print()
        {
            Node<T> temp = this.head;
            while (temp != null)
            {
                Console.WriteLine(temp.GetValue());
                temp = temp.GetNext();
            }
        }

        public void Delete(int index)
        {
            if (index == 0){
                this.head = this.head.GetNext();
                return;
            }

            Node<T> temp = this.head;
            int counter = 1;
            while (temp.GetNext() != null)
            {
                if (counter == index)
                {
                    temp.SetNext(temp.GetNext().GetNext());
                    return;
                }else{
                    temp = temp.GetNext();
                    counter++;
                }
            }
            Console.WriteLine("No se pudo encontrar el elemento");
        }

        public T Get(int index)
        {
            Node<T> temp = this.head;
            int counter = 0;
            while (temp != null)
            {
                if (counter == index)
                {
                    return temp.GetValue();
                }
                else
                {
                    temp = temp.GetNext();
                    counter++;
                }
            }
            return default(T);
        }

        public class Node<T>
        {
            Node<T> next = null;
            T value;

            public Node(T value)
            {
                this.value = value;
            }

            public Node<T> GetNext()
            {
                return next;
            }

            public void SetNext(Node<T> node)
            {
                next = node;
            }

            public T GetValue()
            {
                return this.value;
            }
        }
    }
}