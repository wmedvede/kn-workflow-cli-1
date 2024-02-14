/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.kie.kogito.examples.sw.temp.multiplication;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

import io.quarkus.runtime.annotations.RegisterForReflection;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OperationResource {

    @POST
    @APIResponseSchema(value = OperationResource.Result.class, responseDescription = "MultiplicationResult", responseCode = "200")
    @Operation(operationId = "multiply")
    public Response doOperation(@NotNull MultiplicationOperation operation) {
        return Response.ok(new Result(operation.getLeftElement() * operation.getRightElement())).build();
    }

    @RegisterForReflection
    public static final class Result {

        float product;

        public Result() {
        }

        public Result(float product) {
            this.product = product;
        }

        public float getProduct() {
            return product;
        }

    }
}
