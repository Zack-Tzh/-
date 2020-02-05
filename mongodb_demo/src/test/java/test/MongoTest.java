package test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @title: MongoTest
 * @projectName: tensquare_parent
 * @description: TODO
 * @author: Zack_Tzh
 * @date: 2020/2/3  22:25
 */
public class MongoTest {
    //查询所有数据db.comment.find()
    @Test
    public void test1() {
        //1.创建操作mongodb的客服端
        MongoClient client = new MongoClient("192.168.200.128",27017);
        //2.选择数据库use.commentdb
        MongoDatabase commentdb = client.getDatabase("commentdb");
        //3.选取集合use.comment
        MongoCollection<Document> comment = commentdb.getCollection("comment");
        //4.使用集合进行查询,db.comment.find()
        Map map = new HashMap();
        map.put("name","lisi");
        Document document = new Document(map);
        comment.insertOne(document);
        client.close();

    }
}
