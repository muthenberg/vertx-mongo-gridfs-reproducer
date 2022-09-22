# vertx-mongo-gridfs-reproducer
A project reproducing an error encountered while uploading data to GridFS

To run you need a running Mongo Database (I used version 5.0.12 Community) with no authentication.

The relevant code is located in the Unit tests. There is one implementation using Java and another using Kotlin.

The encountered error should be

```
Can't find a codec for class java.util.LinkedHashMap$Entry.
org.bson.codecs.configuration.CodecConfigurationException: Can't find a codec for class java.util.LinkedHashMap$Entry.
	at app//org.bson.internal.CodecCache.getOrThrow(CodecCache.java:57)
	at app//org.bson.internal.ProvidersCodecRegistry.get(ProvidersCodecRegistry.java:64)
	at app//org.bson.internal.ChildCodecRegistry.get(ChildCodecRegistry.java:52)
	at app//org.bson.codecs.DocumentCodec.writeValue(DocumentCodec.java:202)
	at app//org.bson.codecs.DocumentCodec.writeIterable(DocumentCodec.java:225)
	at app//org.bson.codecs.DocumentCodec.writeValue(DocumentCodec.java:198)
	at app//org.bson.codecs.DocumentCodec.writeMap(DocumentCodec.java:217)
	at app//org.bson.codecs.DocumentCodec.encode(DocumentCodec.java:159)
	at app//org.bson.codecs.DocumentCodec.encode(DocumentCodec.java:46)
	at app//org.bson.codecs.BsonDocumentWrapperCodec.encode(BsonDocumentWrapperCodec.java:63)
	at app//org.bson.codecs.BsonDocumentWrapperCodec.encode(BsonDocumentWrapperCodec.java:29)
	at app//org.bson.codecs.EncoderContext.encodeWithChildContext(EncoderContext.java:91)
	at app//org.bson.codecs.BsonDocumentCodec.writeValue(BsonDocumentCodec.java:139)
	at app//org.bson.codecs.BsonDocumentCodec.encode(BsonDocumentCodec.java:118)
	at app//org.bson.codecs.BsonDocumentCodec.encode(BsonDocumentCodec.java:42)
	at app//com.mongodb.client.gridfs.codecs.GridFSFileCodec.encode(GridFSFileCodec.java:90)
	at app//com.mongodb.client.gridfs.codecs.GridFSFileCodec.encode(GridFSFileCodec.java:47)
	at app//org.bson.codecs.BsonDocumentWrapperCodec.encode(BsonDocumentWrapperCodec.java:63)
	at app//org.bson.codecs.BsonDocumentWrapperCodec.encode(BsonDocumentWrapperCodec.java:29)
	at app//com.mongodb.internal.connection.SplittablePayload$WriteRequestEncoder.encode(SplittablePayload.java:200)
	at app//com.mongodb.internal.connection.SplittablePayload$WriteRequestEncoder.encode(SplittablePayload.java:187)
	at app//org.bson.codecs.BsonDocumentWrapperCodec.encode(BsonDocumentWrapperCodec.java:63)
	at app//org.bson.codecs.BsonDocumentWrapperCodec.encode(BsonDocumentWrapperCodec.java:29)
	at app//com.mongodb.internal.connection.BsonWriterHelper.writeDocument(BsonWriterHelper.java:77)
	at app//com.mongodb.internal.connection.BsonWriterHelper.writePayload(BsonWriterHelper.java:59)
	at app//com.mongodb.internal.connection.CommandMessage.encodeMessageBodyWithMetadata(CommandMessage.java:162)
	at app//com.mongodb.internal.connection.RequestMessage.encode(RequestMessage.java:138)
	at app//com.mongodb.internal.connection.CommandMessage.encode(CommandMessage.java:59)
	at app//com.mongodb.internal.connection.InternalStreamConnection.sendAndReceiveAsync(InternalStreamConnection.java:393)
	at app//com.mongodb.internal.connection.UsageTrackingInternalConnection.sendAndReceiveAsync(UsageTrackingInternalConnection.java:145)
	at app//com.mongodb.internal.connection.DefaultConnectionPool$PooledConnection.sendAndReceiveAsync(DefaultConnectionPool.java:527)
	at app//com.mongodb.internal.connection.CommandProtocolImpl.executeAsync(CommandProtocolImpl.java:77)
	at app//com.mongodb.internal.connection.DefaultServer$DefaultServerProtocolExecutor.executeAsync(DefaultServer.java:273)
	at app//com.mongodb.internal.connection.DefaultServerConnection.executeProtocolAsync(DefaultServerConnection.java:218)
	at app//com.mongodb.internal.connection.DefaultServerConnection.commandAsync(DefaultServerConnection.java:135)
	at app//com.mongodb.internal.operation.MixedBulkWriteOperation.executeCommandAsync(MixedBulkWriteOperation.java:440)
	at app//com.mongodb.internal.operation.MixedBulkWriteOperation.executeBatchesAsync(MixedBulkWriteOperation.java:348)
	at app//com.mongodb.internal.operation.MixedBulkWriteOperation.access$1000(MixedBulkWriteOperation.java:76)
	at app//com.mongodb.internal.operation.MixedBulkWriteOperation$2$1.call(MixedBulkWriteOperation.java:228)
	at app//com.mongodb.internal.operation.OperationHelper.validateWriteRequests(OperationHelper.java:269)
	at app//com.mongodb.internal.operation.MixedBulkWriteOperation$2.call(MixedBulkWriteOperation.java:211)
	at app//com.mongodb.internal.operation.OperationHelper$9.onResult(OperationHelper.java:733)
	at app//com.mongodb.internal.operation.OperationHelper$9.onResult(OperationHelper.java:730)
	at app//com.mongodb.internal.connection.DefaultServer$1.onResult(DefaultServer.java:116)
	at app//com.mongodb.internal.connection.DefaultServer$1.onResult(DefaultServer.java:105)
	at app//com.mongodb.internal.async.ErrorHandlingResultCallback.onResult(ErrorHandlingResultCallback.java:48)
	at app//com.mongodb.internal.connection.DefaultConnectionPool$2.onResult(DefaultConnectionPool.java:229)
	at app//com.mongodb.internal.connection.DefaultConnectionPool$2.onResult(DefaultConnectionPool.java:210)
	at app//com.mongodb.internal.connection.DefaultConnectionPool$PooledConnection$1.onResult(DefaultConnectionPool.java:447)
	at app//com.mongodb.internal.connection.DefaultConnectionPool$PooledConnection$1.onResult(DefaultConnectionPool.java:438)
	at app//com.mongodb.internal.connection.UsageTrackingInternalConnection$1.onResult(UsageTrackingInternalConnection.java:66)
	at app//com.mongodb.internal.connection.UsageTrackingInternalConnection$1.onResult(UsageTrackingInternalConnection.java:58)
	at app//com.mongodb.internal.connection.InternalStreamConnection$1$1.onResult(InternalStreamConnection.java:189)
	at app//com.mongodb.internal.connection.InternalStreamConnection$1$1.onResult(InternalStreamConnection.java:175)
	at app//com.mongodb.internal.connection.InternalStreamConnectionInitializer.completeConnectionDescriptionInitializationAsync(InternalStreamConnectionInitializer.java:215)
	at app//com.mongodb.internal.connection.InternalStreamConnectionInitializer.access$100(InternalStreamConnectionInitializer.java:44)
	at app//com.mongodb.internal.connection.InternalStreamConnectionInitializer$1.onResult(InternalStreamConnectionInitializer.java:83)
	at app//com.mongodb.internal.connection.InternalStreamConnectionInitializer$1.onResult(InternalStreamConnectionInitializer.java:76)
	at app//com.mongodb.internal.connection.InternalStreamConnectionInitializer$2.onResult(InternalStreamConnectionInitializer.java:195)
	at app//com.mongodb.internal.connection.InternalStreamConnectionInitializer$2.onResult(InternalStreamConnectionInitializer.java:176)
	at app//com.mongodb.internal.connection.CommandHelper$1.onResult(CommandHelper.java:59)
	at app//com.mongodb.internal.connection.CommandHelper$1.onResult(CommandHelper.java:53)
	at app//com.mongodb.internal.connection.InternalStreamConnection$2$1.onResult(InternalStreamConnection.java:463)
	at app//com.mongodb.internal.connection.InternalStreamConnection$2$1.onResult(InternalStreamConnection.java:440)
	at app//com.mongodb.internal.connection.InternalStreamConnection$MessageHeaderCallback$MessageCallback.onResult(InternalStreamConnection.java:745)
	at app//com.mongodb.internal.connection.InternalStreamConnection$MessageHeaderCallback$MessageCallback.onResult(InternalStreamConnection.java:712)
	at app//com.mongodb.internal.connection.InternalStreamConnection$5.completed(InternalStreamConnection.java:582)
	at app//com.mongodb.internal.connection.InternalStreamConnection$5.completed(InternalStreamConnection.java:579)
	at app//com.mongodb.internal.connection.AsynchronousChannelStream$BasicCompletionHandler.completed(AsynchronousChannelStream.java:250)
	at app//com.mongodb.internal.connection.AsynchronousChannelStream$BasicCompletionHandler.completed(AsynchronousChannelStream.java:233)
	at java.base@11.0.11/sun.nio.ch.Invoker.invokeUnchecked(Invoker.java:127)
	at java.base@11.0.11/sun.nio.ch.Invoker.invokeDirect(Invoker.java:158)
	at java.base@11.0.11/sun.nio.ch.UnixAsynchronousSocketChannelImpl.implRead(UnixAsynchronousSocketChannelImpl.java:562)
	at java.base@11.0.11/sun.nio.ch.AsynchronousSocketChannelImpl.read(AsynchronousSocketChannelImpl.java:277)
	at java.base@11.0.11/sun.nio.ch.AsynchronousSocketChannelImpl.read(AsynchronousSocketChannelImpl.java:298)
	at app//com.mongodb.internal.connection.AsynchronousSocketChannelStream$AsynchronousSocketChannelAdapter.read(AsynchronousSocketChannelStream.java:144)
	at app//com.mongodb.internal.connection.AsynchronousChannelStream.readAsync(AsynchronousChannelStream.java:118)
	at app//com.mongodb.internal.connection.AsynchronousChannelStream.readAsync(AsynchronousChannelStream.java:107)
	at app//com.mongodb.internal.connection.InternalStreamConnection.readAsync(InternalStreamConnection.java:579)
	at app//com.mongodb.internal.connection.InternalStreamConnection.access$1100(InternalStreamConnection.java:78)
	at app//com.mongodb.internal.connection.InternalStreamConnection$MessageHeaderCallback.onResult(InternalStreamConnection.java:702)
	at app//com.mongodb.internal.connection.InternalStreamConnection$MessageHeaderCallback.onResult(InternalStreamConnection.java:687)
	at app//com.mongodb.internal.connection.InternalStreamConnection$5.completed(InternalStreamConnection.java:582)
	at app//com.mongodb.internal.connection.InternalStreamConnection$5.completed(InternalStreamConnection.java:579)
	at app//com.mongodb.internal.connection.AsynchronousChannelStream$BasicCompletionHandler.completed(AsynchronousChannelStream.java:250)
	at app//com.mongodb.internal.connection.AsynchronousChannelStream$BasicCompletionHandler.completed(AsynchronousChannelStream.java:233)
	at java.base@11.0.11/sun.nio.ch.Invoker.invokeUnchecked(Invoker.java:127)
	at java.base@11.0.11/sun.nio.ch.UnixAsynchronousSocketChannelImpl.finishRead(UnixAsynchronousSocketChannelImpl.java:439)
	at java.base@11.0.11/sun.nio.ch.UnixAsynchronousSocketChannelImpl.finish(UnixAsynchronousSocketChannelImpl.java:191)
	at java.base@11.0.11/sun.nio.ch.UnixAsynchronousSocketChannelImpl.onEvent(UnixAsynchronousSocketChannelImpl.java:213)
	at java.base@11.0.11/sun.nio.ch.KQueuePort$EventHandlerTask.run(KQueuePort.java:312)
	at java.base@11.0.11/sun.nio.ch.AsynchronousChannelGroupImpl$1.run(AsynchronousChannelGroupImpl.java:112)
	at java.base@11.0.11/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base@11.0.11/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base@11.0.11/java.lang.Thread.run(Thread.java:829)
```
