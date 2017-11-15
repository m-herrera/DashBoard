using NUnit.Framework;
using System;
namespace org.tec.datastructures.tests
{
    [TestFixture()]
    public class QueueTest
    {
        [Test()]
        public void Push()
        {
            Queue<String> queue = new Queue<string>();
            queue.Push("Hola");
            queue.Push("Prueba");
            Assert.IsFalse(queue.IsEmpty());
            Assert.AreEqual("Hola", queue.Peek());
            Assert.AreEqual("Hola", queue.Pop());
        }

        [Test()]
        public void Peek()
        {
            Queue<String> Queue = new Queue<string>();
            Queue.Push("Hola");
            Assert.AreEqual("Hola", Queue.Peek());
            Queue.Push("Prueba");
            Assert.AreEqual("Hola", Queue.Peek());
        }

        [Test()]
        public void Pop()
        {
            Queue<String> Queue = new Queue<string>();
            Queue.Push("Hola");
            Queue.Push("Prueba");
            Assert.AreEqual("Hola", Queue.Pop());
            Assert.AreEqual("Prueba",Queue.Pop());
        }
    }
}
