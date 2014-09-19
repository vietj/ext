/*
 * Copyright 2014 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */

package io.vertx.ext.reactivestreams;

import io.vertx.core.ServiceHelper;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.streams.ReadStream;
import io.vertx.ext.reactivestreams.spi.ReactiveReadStreamFactory;
import org.reactivestreams.Subscriber;

/**
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public interface ReactiveReadStream extends ReadStream<ReactiveReadStream, Buffer>, Subscriber<Buffer> {

  static final int DEFAULT_BUFFER_REQUEST_BATCH_SIZE = 4;

  static ReactiveReadStream readStream() {
    return factory.readStream();
  }

  static final ReactiveReadStreamFactory factory = ServiceHelper.loadFactory(ReactiveReadStreamFactory.class);

}
