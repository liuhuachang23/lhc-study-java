package hsp.chapter18.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/4 20:04
 * @Description: 演示 Properties 的使用
 * 添加 key-val 到新文件 mysql2.properties 中，并修改某个 key-val
 */
public class Properties03 {
    public static void main(String[] args) throws IOException {
        //1）使用Properties 类来创建 配置文件，修改配置文件内容
        Properties properties = new Properties();
        //2）创建
        properties.setProperty("charset", "utf-8");
        properties.setProperty("user", "吴小文"); //中文会保存其对应的Unicode码
        properties.setProperty("pwd", "wwl112911wwl");
        //3）修改某个key-val （可以理解为 覆盖性创建）
        //如果该文件没有key 就是创建
        //如果存在，就是修改
        /* properties.setProperty() 底层是 Hashtable的put()方法
            public synchronized V put(K key, V value) {
                // Make sure the value is not null
                if (value == null) {
                    throw new NullPointerException();
                }

                // Makes sure the key is not already in the hashtable.
                Entry<?,?> tab[] = table;
                int hash = key.hashCode();
                int index = (hash & 0x7FFFFFFF) % tab.length;
                @SuppressWarnings("unchecked")
                Entry<K,V> entry = (Entry<K,V>)tab[index];
                for(; entry != null ; entry = entry.next) {
                    if ((entry.hash == hash) && entry.key.equals(key)) {
                        V old = entry.value;
                        entry.value = value; //如果key 存在 就替换
                        return old;
                    }
                }

                addEntry(hash, key, value, index); //如果是新的key 就创建
                return null;
            }
         */
        properties.setProperty("charset","gbj"); //修改
        properties.setProperty("area", "抚州"); //创建
        properties.setProperty("tel", "17379047790"); //创建
        //4）将 Entry<k,v> 存储到新文件中
        //store() 第二个参数是 填写备注
        properties.store(new FileOutputStream("src\\hsp\\chapter18\\properties\\mysql2.properties"), null);
        System.out.println("保存配置文件成功~");


    }
}
