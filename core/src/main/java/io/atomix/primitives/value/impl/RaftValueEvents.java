/*
 * Copyright 2017-present Open Networking Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.atomix.primitives.value.impl;

import io.atomix.primitives.value.AtomicValueEvent;
import io.atomix.protocols.raft.event.EventType;
import io.atomix.serializer.kryo.KryoNamespace;
import io.atomix.serializer.kryo.KryoNamespaces;

/**
 * Raft value events.
 */
public enum RaftValueEvents implements EventType {
  CHANGE("change");

  private final String id;

  RaftValueEvents(String id) {
    this.id = id;
  }

  @Override
  public String id() {
    return id;
  }

  public static final KryoNamespace NAMESPACE = KryoNamespace.newBuilder()
      .nextId(KryoNamespaces.BEGIN_USER_CUSTOM_ID + 50)
      .register(AtomicValueEvent.class)
      .register(AtomicValueEvent.Type.class)
      .register(byte[].class)
      .build("RaftValueEvents");

}
