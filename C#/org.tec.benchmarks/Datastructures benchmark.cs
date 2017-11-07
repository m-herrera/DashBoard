using System;
using org.tec.datastructures;

namespace org.tec.benchmarks
{
    public class Benchmark
    {
        public static void Main(String[] args){
            SimpleList<String> list = new SimpleList<String>();
            list.Append("Hey");
            list.Append("Hola");
            list.Append("Que hay");
            list.Print();
            Console.WriteLine("-----------------");
            list.Delete(0);
            list.Print();
        }
    }
}
