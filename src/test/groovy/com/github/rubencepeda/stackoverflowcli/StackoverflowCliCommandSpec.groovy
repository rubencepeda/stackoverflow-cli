package com.github.rubencepeda.stackoverflowcli

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment

import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

import java.io.ByteArrayOutputStream
import java.io.PrintStream

class StackoverflowCliCommandSpec extends Specification {

    @Shared @AutoCleanup ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)

    void "test stackoverflow-cli search command"() {
        given:
        ByteArrayOutputStream baos = new ByteArrayOutputStream()
        PrintStream out = System.out
        System.setOut(new PrintStream(baos))

        String[] args = ['search', '-q', 'merge maps', '-t', 'java', '--verbose'] as String[]
        PicocliRunner.run(StackoverflowCliCommand, ctx, args)
        out.println(baos.toString())

        expect:
        baos.toString().contains('Search command running...')
    }
}

