package test.vertx.gridfs;

import io.vertx.core.Vertx;
import io.vertx.core.file.OpenOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.GridFsUploadOptions;
import io.vertx.ext.mongo.MongoClient;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(VertxExtension.class)
public class JavaTest {
    @Test
    public void myTest(final Vertx vertx, final VertxTestContext context) {
        var config = new JsonObject().put("connection_string", "mongodb://localhost:55000");
        var client = MongoClient.createShared(vertx, config);
        var fs = vertx.fileSystem();

        fs.open("test.txt", new OpenOptions(), context.succeeding(asyncFile -> {
            client.createDefaultGridFsBucketService(context.succeeding(gridFS -> {
                var options = new GridFsUploadOptions();
                options.setMetadata(new JsonObject().put("test", new JsonObject().put("test", "test")));
                gridFS.uploadByFileNameWithOptions(
                    asyncFile,
                    "test.txt",
                    options, context.succeeding( result -> {
                    context.verify(() -> {
                        assertNotNull(result);
                    });
                context.completeNow();
                }));
            }));
        }));
    }
}
