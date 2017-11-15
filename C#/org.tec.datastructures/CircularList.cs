using System;
namespace org.tec.datastructures
{
    public class CircularList<T>
    {
        Node<T> tail;
        int lenght = 0;

        public void Append(T value)
        {
            if (tail == null)
            {
                tail = new Node<T>(value);
                tail.SetNext(tail);
                this.lenght++;
            }
            else
            {
                Node<T> nodo = tail;
                Node<T> newNode = new Node<T>(value);
                newNode.SetNext(nodo.GetNext());
                nodo.SetNext(newNode);
                tail = newNode;
                this.lenght++;

            }
        }

        public void Print()
        {
            Node<T> head = tail.GetNext();
            Node<T> temp = tail.GetNext();
            Console.WriteLine(temp.GetValue());
            temp = temp.GetNext();
            while (temp != head)
            {
                Console.WriteLine(temp.GetValue());
                temp = temp.GetNext();
            }
        }

        public void Delete(int index)
        {
            Node<T> temp = this.tail;
            int counter = 0;
            do
            {
                if (counter == index)
                {
                    temp.SetNext(temp.GetNext().GetNext());
                    this.lenght--;
                    return;
                }
                else
                {
                    temp = temp.GetNext();
                    counter++;
                }
            } while (temp.GetNext() != tail.GetNext());
            Console.WriteLine("No se pudo encontrar el elemento");
        }

        public T Get(int index)
        {
            Node<T> temp = this.tail.GetNext();
            int counter = 0;
            do
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
            } while (temp != this.tail.GetNext());
            throw new ArgumentOutOfRangeException();
        }

        public Boolean IsEmpty(){
            return this.tail == null;
        }

        public int Lenght(){
            return this.lenght;
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