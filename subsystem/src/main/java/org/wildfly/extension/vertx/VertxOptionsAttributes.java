/*
 *  Copyright (c) 2022 The original author or authors
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of Apache License v2.0 which
 *  accompanies this distribution.
 *
 *       The Apache License v2.0 is available at
 *       http://www.opensource.org/licenses/apache2.0.php
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package org.wildfly.extension.vertx;

import org.jboss.as.controller.AttributeDefinition;
import org.jboss.as.controller.AttributeMarshaller;
import org.jboss.as.controller.AttributeParser;
import org.jboss.as.controller.ObjectTypeAttributeDefinition;
import org.jboss.as.controller.ParameterCorrector;
import org.jboss.as.controller.SimpleAttributeDefinition;
import org.jboss.as.controller.SimpleAttributeDefinitionBuilder;
import org.jboss.as.controller.StringListAttributeDefinition;
import org.jboss.as.controller.operations.validation.IntRangeValidator;
import org.jboss.as.controller.operations.validation.LongRangeValidator;
import org.jboss.as.controller.operations.validation.StringLengthValidator;
import org.jboss.dmr.ModelNode;
import org.jboss.dmr.ModelType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:aoingl@gmail.com">Lin Gao</a>
 */
public abstract class VertxOptionsAttributes {

  public static final SimpleAttributeDefinition VERTX_OPTION_FILE_PATH = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_PATH, ModelType.STRING)
    .setRequired(true)
    .setAllowExpression(true)
    .setRestartAllServices()
    .build();

  private static final List<AttributeDefinition> VERTX_OPTIONS_FILE_ATTRS = new ArrayList<>();
  static {
    VERTX_OPTIONS_FILE_ATTRS.add(VERTX_OPTION_FILE_PATH);
  }

  /**
   * @return Attributes used in element like: /subsystem=vertx/vertx-options-file=vof
   */
  static List<AttributeDefinition> getVertxOptionsFileAttributes() {
    return VERTX_OPTIONS_FILE_ATTRS;
  }

  private static final String[] TIME_UNITS = Arrays.stream(TimeUnit.values()).map(Enum::toString).collect(Collectors.toList()).toArray(new String[0]);

  public static final SimpleAttributeDefinition ATTR_EVENTLOOP_POOL_SIZE = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_EVENTLOOP_POOL_SIZE, ModelType.INT)
    .setRequired(false)
    .setAllowExpression(true)
    .setValidator(new IntRangeValidator(1,  true))
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_WORKER_POOL_SIZE = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_WORKER_POOL_SIZE, ModelType.INT)
    .setRequired(false)
    .setAllowExpression(true)
    .setValidator(new IntRangeValidator(1,  true))
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_INTERNAL_BLOCKING_POOL_SIZE = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_INTERNAL_BLOCKING_POOL_SIZE, ModelType.INT)
    .setRequired(false)
    .setAllowExpression(true)
    .setValidator(new IntRangeValidator(1,  true))
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_HA_ENABLED = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_HA_ENABLED, ModelType.BOOLEAN)
    .setRequired(false)
    .setAllowExpression(true)
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_HA_GROUP = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_HA_GROUP, ModelType.STRING)
    .setRequired(false)
    .setAllowExpression(true)
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_QUORUM_SIZE = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_QUORUM_SIZE, ModelType.INT)
    .setRequired(false)
    .setAllowExpression(true)
    .setValidator(new IntRangeValidator(1,  true))
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_PREFER_NATIVE_TRANSPORT = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_PREFER_NATIVE_TRANSPORT, ModelType.BOOLEAN)
    .setRequired(false)
    .setAllowExpression(true)
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_DISABLE_TCCL = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_DISABLE_TCCL, ModelType.BOOLEAN)
    .setRequired(false)
    .setAllowExpression(true)
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_BLOCKED_THREAD_CHECK_INTERVAL = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_BLOCKED_THREAD_CHECK_INTERVAL, ModelType.LONG)
    .setRequired(false)
    .setAllowExpression(true)
    .setValidator(new LongRangeValidator(1,  true))
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_BLOCKED_THREAD_CHECK_INTERVAL_UNIT = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_BLOCKED_THREAD_CHECK_INTERVAL_UNIT, ModelType.STRING)
    .setRequired(false)
    .setAllowExpression(true)
    .setAllowedValues(TIME_UNITS)
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_MAX_EVENTLOOP_EXECUTE_TIME = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_MAX_EVENTLOOP_EXECUTE_TIME, ModelType.LONG)
    .setRequired(false)
    .setAllowExpression(true)
    .setValidator(new LongRangeValidator(1,  true))
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_MAX_EVENTLOOP_EXECUTE_TIME_UNIT = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_MAX_EVENTLOOP_EXECUTE_TIME_UNIT, ModelType.STRING)
    .setRequired(false)
    .setAllowExpression(true)
    .setAllowedValues(TIME_UNITS)
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_MAX_WORKER_EXECUTE_TIME = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_MAX_WORKER_EXECUTE_TIME, ModelType.LONG)
    .setRequired(false)
    .setAllowExpression(true)
    .setValidator(new LongRangeValidator(1,  true))
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_MAX_WORKER_EXECUTE_TIME_UNIT = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_MAX_WORKER_EXECUTE_TIME_UNIT, ModelType.STRING)
    .setRequired(false)
    .setAllowExpression(true)
    .setAllowedValues(TIME_UNITS)
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_WARNING_EXECUTION_TIME = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_WARNING_EXECUTION_TIME, ModelType.LONG)
    .setRequired(false)
    .setAllowExpression(true)
    .setValidator(new LongRangeValidator(1,  true))
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_WARNING_EXECUTION_TIME_UNIT = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_WARNING_EXECUTION_TIME_UNIT, ModelType.STRING)
    .setRequired(false)
    .setAllowExpression(true)
    .setAllowedValues(TIME_UNITS)
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_FS_CLASS_PATH_RESOLVING_ENABLED = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_FS_CLASS_PATH_RESOLVING_ENABLED, ModelType.BOOLEAN)
    .setRequired(false)
    .setAllowExpression(true)
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_FS_FILE_CACHE_ENABLED = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_FS_FILE_CACHE_ENABLED, ModelType.BOOLEAN)
    .setRequired(false)
    .setAllowExpression(true)
    .setRestartAllServices()
    .build();

  // AddressResolverOptions
  public static final SimpleAttributeDefinition ATTR_HOSTS_PATH = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_HOSTS_PATH, ModelType.STRING)
    .setRequired(false)
    .setAllowExpression(true)
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_HOSTS_VALUE = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_HOSTS_VALUE, ModelType.STRING)
    .setRequired(false)
    .setAllowExpression(true)
    .setRestartAllServices()
    .build();

  public static final StringListAttributeDefinition ATTR_SERVERS = new StringListAttributeDefinition.Builder(VertxConstants.ATTR_SERVERS)
    .setRequired(false)
    .setRestartAllServices()
    .setElementValidator(new StringLengthValidator(1))
    .setAllowExpression(true)
    .setAttributeParser(AttributeParser.COMMA_DELIMITED_STRING_LIST)
    .setAttributeMarshaller(AttributeMarshaller.COMMA_STRING_LIST)
    .build();

  public static final SimpleAttributeDefinition ATTR_OPT_RES_ENABLED = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_OPT_RES_ENABLED, ModelType.BOOLEAN)
    .setRequired(false)
    .setAllowExpression(true)
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_CACHE_MIN_TTL = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_CACHE_MIN_TTL, ModelType.INT)
    .setRequired(false)
    .setAllowExpression(true)
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_MAX_TTL = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_MAX_TTL, ModelType.INT)
    .setRequired(false)
    .setAllowExpression(true)
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_NEGATIVE_TTL = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_NEGATIVE_TTL, ModelType.INT)
    .setRequired(false)
    .setAllowExpression(true)
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_QUERY_TIMEOUT = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_QUERY_TIMEOUT, ModelType.LONG)
    .setRequired(false)
    .setAllowExpression(true)
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_MAX_QUERIES = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_MAX_QUERIES, ModelType.INT)
    .setRequired(false)
    .setAllowExpression(true)
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_RD_FLAG = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_RD_FLAG, ModelType.BOOLEAN)
    .setRequired(false)
    .setAllowExpression(true)
    .setRestartAllServices()
    .build();

  public static final StringListAttributeDefinition ATTR_SEARCH_DOMAIN = new StringListAttributeDefinition.Builder(VertxConstants.ATTR_SEARCH_DOMAIN)
    .setRequired(false)
    .setRestartAllServices()
    .setElementValidator(new StringLengthValidator(1))
    .setAllowExpression(true)
    .setAttributeParser(AttributeParser.COMMA_DELIMITED_STRING_LIST)
    .setAttributeMarshaller(AttributeMarshaller.COMMA_STRING_LIST)
    .build();

  public static final SimpleAttributeDefinition ATTR_N_DOTS = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_N_DOTS, ModelType.INT)
    .setRequired(false)
    .setAllowExpression(true)
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_ROTATE_SERVERS = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_ROTATE_SERVERS, ModelType.BOOLEAN)
    .setRequired(false)
    .setAllowExpression(true)
    .setRestartAllServices()
    .build();

  public static final SimpleAttributeDefinition ATTR_ROUND_ROBIN_INET_ADDRESS = new SimpleAttributeDefinitionBuilder(VertxConstants.ATTR_ROUND_ROBIN_INET_ADDRESS, ModelType.BOOLEAN)
    .setRequired(false)
    .setAllowExpression(true)
    .setRestartAllServices()
    .build();

  private static final List<AttributeDefinition> VERTX_ADDRESS_RESOLVER_OPTIONS_ATTRS = new ArrayList<>();
  static {
    VERTX_ADDRESS_RESOLVER_OPTIONS_ATTRS.add(ATTR_HOSTS_PATH);

    VERTX_ADDRESS_RESOLVER_OPTIONS_ATTRS.add(ATTR_HOSTS_VALUE);
    VERTX_ADDRESS_RESOLVER_OPTIONS_ATTRS.add(ATTR_SERVERS);
    VERTX_ADDRESS_RESOLVER_OPTIONS_ATTRS.add(ATTR_OPT_RES_ENABLED);
    VERTX_ADDRESS_RESOLVER_OPTIONS_ATTRS.add(ATTR_CACHE_MIN_TTL);
    VERTX_ADDRESS_RESOLVER_OPTIONS_ATTRS.add(ATTR_MAX_TTL);
    VERTX_ADDRESS_RESOLVER_OPTIONS_ATTRS.add(ATTR_NEGATIVE_TTL);
    VERTX_ADDRESS_RESOLVER_OPTIONS_ATTRS.add(ATTR_QUERY_TIMEOUT);
    VERTX_ADDRESS_RESOLVER_OPTIONS_ATTRS.add(ATTR_MAX_QUERIES);
    VERTX_ADDRESS_RESOLVER_OPTIONS_ATTRS.add(ATTR_RD_FLAG);
    VERTX_ADDRESS_RESOLVER_OPTIONS_ATTRS.add(ATTR_SEARCH_DOMAIN);
    VERTX_ADDRESS_RESOLVER_OPTIONS_ATTRS.add(ATTR_N_DOTS);
    VERTX_ADDRESS_RESOLVER_OPTIONS_ATTRS.add(ATTR_ROTATE_SERVERS);
    VERTX_ADDRESS_RESOLVER_OPTIONS_ATTRS.add(ATTR_ROUND_ROBIN_INET_ADDRESS);
  }

  private static List<AttributeDefinition> getVertxAddressResolverOptionsAttrs() {
    return VERTX_ADDRESS_RESOLVER_OPTIONS_ATTRS;
  }

  public static final ObjectTypeAttributeDefinition ATTR_ADDRESS_RESOLVER = new ObjectTypeAttributeDefinition
    .Builder(VertxConstants.ATTR_ADDRESS_RESOLVER,
    getVertxAddressResolverOptionsAttrs().toArray(new AttributeDefinition[0]))
    .setRestartAllServices()
    .build();

  private static final List<AttributeDefinition> VERTX_OPTIONS_ATTRS = new ArrayList<>();
  static {
    VERTX_OPTIONS_ATTRS.add(ATTR_EVENTLOOP_POOL_SIZE);
    VERTX_OPTIONS_ATTRS.add(ATTR_WORKER_POOL_SIZE);
    VERTX_OPTIONS_ATTRS.add(ATTR_INTERNAL_BLOCKING_POOL_SIZE);
    VERTX_OPTIONS_ATTRS.add(ATTR_HA_ENABLED);
    VERTX_OPTIONS_ATTRS.add(ATTR_HA_GROUP);
    VERTX_OPTIONS_ATTRS.add(ATTR_QUORUM_SIZE);
    VERTX_OPTIONS_ATTRS.add(ATTR_PREFER_NATIVE_TRANSPORT);
    VERTX_OPTIONS_ATTRS.add(ATTR_DISABLE_TCCL);
    VERTX_OPTIONS_ATTRS.add(ATTR_BLOCKED_THREAD_CHECK_INTERVAL);
    VERTX_OPTIONS_ATTRS.add(ATTR_BLOCKED_THREAD_CHECK_INTERVAL_UNIT);
    VERTX_OPTIONS_ATTRS.add(ATTR_MAX_EVENTLOOP_EXECUTE_TIME);
    VERTX_OPTIONS_ATTRS.add(ATTR_MAX_EVENTLOOP_EXECUTE_TIME_UNIT);
    VERTX_OPTIONS_ATTRS.add(ATTR_MAX_WORKER_EXECUTE_TIME);
    VERTX_OPTIONS_ATTRS.add(ATTR_MAX_WORKER_EXECUTE_TIME_UNIT);
    VERTX_OPTIONS_ATTRS.add(ATTR_WARNING_EXECUTION_TIME);
    VERTX_OPTIONS_ATTRS.add(ATTR_WARNING_EXECUTION_TIME_UNIT);

    // file system options
    VERTX_OPTIONS_ATTRS.add(ATTR_FS_CLASS_PATH_RESOLVING_ENABLED);
    VERTX_OPTIONS_ATTRS.add(ATTR_FS_FILE_CACHE_ENABLED);

    // address resolver options
    VERTX_OPTIONS_ATTRS.add(ATTR_ADDRESS_RESOLVER);
  }

  /**
   * @return Attributes used in element like: /subsystem=vertx/vertx-option=vo
   */
  static List<AttributeDefinition> getVertxOptionsAttributes() {
    return VERTX_OPTIONS_ATTRS;
  }

}
