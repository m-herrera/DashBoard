using NUnit.Framework;
using System;
namespace org.tec.datastructures.tests
{
    [TestFixture()]
    public class CircularListTest
    {
        [Test()]
        public void AppendTest()
        {
            CircularList<string> list = new CircularList<string>();
            list.Append("Prueba");
            list.Append("Prueba2");
            Assert.AreEqual("Prueba", list.Get(0));
            Assert.AreEqual("Prueba2", list.Get(1));
        }

        [Test()]
        public void DeleteTest(){
            CircularList<string> list = new CircularList<string>();
            list.Append("1");
            list.Append("2");
            list.Append("3");
            list.Append("4");
            list.Append("5");

            list.Delete(0);
            Assert.AreEqual("2", list.Get(0));

            list.Delete(1);
            Assert.AreEqual("4", list.Get(1));

            list.Delete(2);
            Assert.Throws<ArgumentOutOfRangeException>(delegate
            {
                list.Get(2);
            });
        }

        [Test()]
        public void IsEmptyTest(){
            CircularList<int> list = new CircularList<int>();
            Assert.IsTrue(list.IsEmpty());
            list.Append(4);
            Assert.IsFalse(list.IsEmpty());
        }

        [Test()]
        public void LengthTest()
        {
            CircularList<int> list = new CircularList<int>();
            list.Append(4);
            list.Append(9);
            Assert.AreEqual(2, list.Lenght());
        }

    }
}
