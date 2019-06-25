/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.johnzon.core;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BufferStrategyFactoryTest {

    @Test
    public void testDefaultStrategies() {
        verify(BufferStrategyFactory.valueOf("BY_INSTANCE"));
        verify(BufferStrategyFactory.valueOf("THREAD_LOCAL"));
        verify(BufferStrategyFactory.valueOf("QUEUE"));
        verify(BufferStrategyFactory.valueOf("SINGLETON"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotExistingStrategy() {
        BufferStrategyFactory.valueOf("NOT_EXISTING");
    }

    @Test
    public void testFqcnBufferStrategy() {
        verify(BufferStrategyFactory.valueOf(DummyBufferStrategy.class.getName()));
    }

    private void verify(Object bufferStrategy) {
        assertNotNull(bufferStrategy);
        assertTrue(bufferStrategy instanceof BufferStrategy);
    }

    public static final class DummyBufferStrategy implements BufferStrategy {
        @Override
        public BufferProvider<char[]> newCharProvider(int size) {
            return null;
        }

        @Override
        public BufferProvider<StringBuilder> newStringBuilderProvider(int size) {
            return null;
        }
    }
}
