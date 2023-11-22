package com.example.Billingjob;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.batch.core.JobParametersBuilder;

@SpringBootTest
@ExtendWith(OutputCaptureExtension.class)
class BillingJobApplicationTests {

	@Autowired
	private Job job;

	@Autowired
	private JobLauncher jobLauncher;

	@Test
	void testJodExec(CapturedOutput output) throws Exception {

		JobParameters jobParameters = new JobParametersBuilder().addString("input.file", "billing-data.csv")
				.addString("file.format", "csv", false)
				.toJobParameters();

		JobExecution jobExecution = this.jobLauncher.run(this.job, jobParameters);
		Assertions.assertTrue(output.getOut().contains("processing billing information from file /some/input/file"));
		Assertions.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
	}

}
