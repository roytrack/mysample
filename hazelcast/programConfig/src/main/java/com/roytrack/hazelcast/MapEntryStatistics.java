package com.roytrack.hazelcast;

import com.hazelcast.core.EntryView;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class MapEntryStatistics {
  public static void main(String[] args) {
    HazelcastInstance hz = Hazelcast.newHazelcastInstance();
    hz.getMap("quotes").put("1",43434);
    EntryView entry  = hz.getMap("quotes").getEntryView("1");
    System.out.println ( "size in memory  : " + entry.getCost() );
    System.out.println ( "creationTime    : " + entry.getCreationTime() );
    System.out.println ( "expirationTime  : " + entry.getExpirationTime() );
    System.out.println ( "number of hits  : " + entry.getHits() );
    System.out.println ( "lastAccessedTime: " + entry.getLastAccessTime() );
    System.out.println ( "lastUpdateTime  : " + entry.getLastUpdateTime() );
    System.out.println ( "version: " + entry.getVersion() );
    System.out.println ( "key: " + entry.getKey() );
    System.out.println ( "value: " + entry.getValue() );

  }
}
