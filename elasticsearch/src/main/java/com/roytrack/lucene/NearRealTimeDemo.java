package com.roytrack.lucene;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by roytrack on 2016-08-01.
 */
public class NearRealTimeDemo {

    @Test
    public void testRealTimeSearch() throws IOException {
        Directory dir=new RAMDirectory();
        IndexWriterConfig config=new IndexWriterConfig(Version.LUCENE_4_10_3,new StandardAnalyzer());
        IndexWriter writer=new IndexWriter(dir,config);
        for(int i=0;i<10;i++){
            Document d=new Document();
            d.add(new StringField("id",""+i, Field.Store.NO));
            d.add(new StringField("text","aaa", Field.Store.YES));
            writer.addDocument(d);
        }

        DirectoryReader reader= DirectoryReader.open(writer, true);
        IndexSearcher searcher=new IndexSearcher(reader);
        Query q=new TermQuery(new Term("text","aaa"));
        TopDocs docs=searcher.search(q,1);
        assertEquals(10, docs.totalHits);
        writer.deleteDocuments(new Term("id", "7"));
        Document d=new Document();
        d.add(new StringField("id", "11", Field.Store.NO));
        d.add(new StringField("text","bbb",Field.Store.YES));
        writer.addDocument(d);
        DirectoryReader reader1=DirectoryReader.openIfChanged(reader);
        assertFalse(reader == reader1);
        reader.close();
        searcher=new IndexSearcher(reader1);
        TopDocs hits=searcher.search(q,10);
        assertEquals(9,hits.totalHits);
        q=new TermQuery(new Term("text","bbb"));
        hits=searcher.search(q,1);
        assertEquals(1,hits.totalHits);
        reader1.close();
        writer.close();
    }
}
