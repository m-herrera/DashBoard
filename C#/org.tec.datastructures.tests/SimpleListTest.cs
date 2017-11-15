using NUnit.Framework;
using System;
namespace org.tec.datastructures.tests
{
    [TestFixture()]
    public class SimpleListTest
    {
        [Test()]
        public void AppendTest()
        {
            SimpleList<string> list = new SimpleList<string>();
            list.Append("Prueba");
            list.Append("Prueba2");
            Assert.AreEqual("Prueba", list.Get(0));
            Assert.AreEqual("Prueba2", list.Get(1));
        }

        [Test()]
        public void DeleteTest(){
            SimpleList<string> list = new SimpleList<string>();
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
            SimpleList<int> list = new SimpleList<int>();
            Assert.IsTrue(list.IsEmpty());
            list.Append(4);
            Assert.IsFalse(list.IsEmpty());
        }

        [Test()]
        public void LengthTest()
        {
            SimpleList<int> list = new SimpleList<int>();
            list.Append(4);
            list.Append(9);
            Assert.AreEqual(2, list.Length());
        }

    }
}
