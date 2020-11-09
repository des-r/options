environments {
    local {
        db {
            url = 'jdbc:oracle:thin:@localhost:49170:XE'
            dbBasicUser = 'OPTIONS_USER'
            dbUsername = 'OPTIONS'
            dbPassword = 'admin'
        }
    }

    test {
        db {
            url = 'jdbc:oracle:thin:@localhost:49170:XE'
            dbBasicUser = 'OPTIONS_TEST'
            dbUsername = 'OPTIONS_TEST'
            dbPassword = 'admintest'
        }
    }

    ora1 {
        db {
            url = 'jdbc:oracle:thin:@localhost:49170:XE'
            dbBasicUser = 'OPTIONS_TEST'
            dbUsername = 'OPTIONS_TEST'
            dbPassword = 'admintest'
        }
    }

    ora2 {
        db {
            url = 'jdbc:oracle:thin:@localhost:49162:XE'
            dbBasicUser = 'OPTIONS_TEST'
            dbUsername = 'OPTIONS_TEST'
            dbPassword = 'admintest'
        }
    }

    ora3 {
        db {
            url = 'jdbc:oracle:thin:@localhost:49163:XE'
            dbBasicUser = 'OPTIONS_TEST'
            dbUsername = 'OPTIONS_TEST'
            dbPassword = 'admintest'
        }
    }

    ora4 {
        db {
            url = 'jdbc:oracle:thin:@localhost:49164:XE'
            dbBasicUser = 'OPTIONS_TEST'
            dbUsername = 'OPTIONS_TEST'
            dbPassword = 'admintest'
        }
    }

    ora5 {
        db {
            url = 'jdbc:oracle:thin:@localhost:49169:XE'
            dbBasicUser = 'OPTIONS_TEST'
            dbUsername = 'OPTIONS_TEST'
            dbPassword = 'admintest'
        }
    }

    ora6 {
        db {
            url = 'jdbc:oracle:thin:@localhost:49166:XE'
            dbBasicUser = 'OPTIONS_TEST'
            dbUsername = 'OPTIONS_TEST'
            dbPassword = 'admintest'
        }
    }

    ora7 {
        db {
            url = 'jdbc:oracle:thin:@localhost:49167:XE'
            dbBasicUser = 'OPTIONS_TEST'
            dbUsername = 'OPTIONS_TEST'
            dbPassword = 'admintest'
        }
    }

    ora8 {
        db {
            url = 'jdbc:oracle:thin:@localhost:49168:XE'
            dbBasicUser = 'OPTIONS_TEST'
            dbUsername = 'OPTIONS_TEST'
            dbPassword = 'admintest'
        }
    }
}