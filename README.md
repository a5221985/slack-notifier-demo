# slack-notifier-demo #
Spring Boot App to Send Notifications to Slack

## REST End-Points ##

		POST http://localhost:8080/notifyToSlack
		
		Accept: application/json
		Content-Type: application/json
		
		{
			"channel": "#notifications", 
			"username": "webhookbot", 
			"text": "This is posted to #notifications and comes from a bot named webhookbot.", 
			"icon_url": "https://slack.com/img/icons/app-57.png"
		}