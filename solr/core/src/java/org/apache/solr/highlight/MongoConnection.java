package org.apache.solr.highlight;

import java.util.Map;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientOptions;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;

public class MongoConnection
{
  private static final Map<String, String> envMap = System.getenv();
  private static final String host = envMap.getOrDefault("MONGO_HOST", "localhost");
  private static final String port = envMap.getOrDefault("MONGO_PORT", "27017");
  private static final MongoClientOptions options = new MongoClientOptions.Builder().socketKeepAlive(true).build();
  private static final MongoClient mongoClient = new MongoClient(new ServerAddress(host, Integer.parseInt(port)), options);

  private static final String databaseString = envMap.getOrDefault("MONGO_DB_NAME", "test");
  private static final MongoDatabase database = mongoClient.getDatabase(databaseString);
  private static final String collectionString = envMap.getOrDefault("MONGO_COLLECTION_NAME", "test");
  public static final MongoCollection<org.bson.Document> collection = database.getCollection(collectionString);
}
